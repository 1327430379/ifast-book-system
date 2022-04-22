package com.fhk.sample.service.impl;


import com.fhk.sample.common.exception.BusinessException;
import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.dao.UserRepository;
import com.fhk.sample.domain.dto.LoginUser;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.AccountService;
import com.fhk.sample.service.UserService;
import com.fhk.sample.util.BeanUtil;
import com.fhk.sample.util.BizAssert;
import com.fhk.sample.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.*;

import static com.fhk.sample.common.constants.CommonConstants.*;
import static com.fhk.sample.common.constants.ExceptionCode.PASSWORD_INPUT_ERROR;

/**
 * @author lingzan
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private AccountService accountService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User register(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        BizAssert.isNull(dbUser, "该用户名已存在");
        this.setCreateUserDefaultParam(user);
        User saveAfter = userRepository.save(user);
        accountService.createAccountForUser(saveAfter);
        return user;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User updateById(User user) {
        User userOfExist = checkUserAndGetUser(user.getId());
        BeanUtil.copyNullProperties(userOfExist, user);
        user.setUpdatedDate(new Date());
        return userRepository.save(user);
    }

    @Override
    public PageVO<User> listByPage(int pageNum, int pageSize, User user) {
//        Sort sortBy = Sort.by(Sort.Order.desc("updatedDate"));
        Pageable pageable = new PageRequest(pageNum, pageSize);
        Specification<User> specification = getSpecification(user);
        Page<User> page = userRepository.findAll(specification, pageable);
        return PageUtil.convert(pageNum, pageSize, page);
    }

    @Override
    public void delete(Integer id) {
        User user = checkUserAndGetUser(id);
        if (user.getUsername().equals("system")) {
            return;
        }
        userRepository.delete(id);
    }

    @Override
    public void approve(Integer id) {
        User user = checkUserAndGetUser(id);
        if (APPROVE_PENDING_STATUS.equals(user.getApproveStatus())) {
            User currentUser = SessionManager.getCurrentUserSession();
            userRepository.updateApproveStatus(id, APPROVE_APPROVED_STATUS, new Date(), currentUser.getUsername());
        } else {
            log.warn("当前用户已经通过审核,勿重复处理");
            return;
        }
        accountService.approve(user.getUsername());
    }

    @Override
    public void updateStatus(Integer id, Integer status) {
        checkUserAndGetUser(id);
        userRepository.updateStatus(id, status);
    }

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public User login(User loginUserParam) {
        String username = loginUserParam.getUsername();
        String password = loginUserParam.getPassword();
        String role = loginUserParam.getRole();
        //AuthenticationManager authenticate进行用户认证
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authentication);
        //如果认证没通过，给出对应的提示
        BizAssert.isNotNull(authenticate, "登录失败");
        Object principal = authenticate.getPrincipal();

        LoginUser loginUser = (LoginUser) principal;
        User user = loginUser.getUser();
        userRepository.updateLastLoginDate(user.getId(), new Date());
        SessionManager.saveUserSession(user);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return user;
    }

//    @Override
//    public User login(User loginUserParam) {
//        String username = loginUserParam.getUsername();
//        String password = loginUserParam.getPassword();
//        String role = loginUserParam.getRole();
//        User user = userRepository.findByUsername(username);
//        BizAssert.isNotNull(user, "用户名不存在");
//        BizAssert.isTrue(APPROVE_APPROVED_STATUS.equals(user.getApproveStatus()), "该用户还未审核通过");
//        BizAssert.isTrue(password.equals(user.getPassword()), PASSWORD_INPUT_ERROR.getCode(), PASSWORD_INPUT_ERROR.getMsg());
//        BizAssert.isTrue(USER_ENABLE_STATUS.equals(user.getStatus()), "该用户已被禁用");
//        BizAssert.isTrue(role.equals(user.getRole()), "角色不匹配");
//        userRepository.updateLastLoginDate(user.getId(), new Date());
//        SessionManager.saveUserSession(user);
//        return user;
//    }

    @Override
    public void logout(String username) {
        SessionManager.invalidate();
    }

    @Override
    public void incrRetries(Integer userId) {
        User user = userRepository.findOne(userId);
        user.setNumberOfRetries(user.getNumberOfRetries() + 1);
        userRepository.save(user);
    }


    private User checkUserAndGetUser(Integer id) {
        return Optional.ofNullable(userRepository.findOne(id)).orElseThrow(() -> new BusinessException("用户不存在"));
    }


    private void setCreateUserDefaultParam(User user) {
        user.setStatus(USER_ENABLE_STATUS);
        user.setApproveStatus(APPROVE_PENDING_STATUS);
        user.setNumberOfRetries(0);
    }

    private Specification<User> getSpecification(User user) {
        return (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(user.getUsername())) {
                predicates.add(cb.equal(root.get("username"), user.getUsername()));
            }
            if (StringUtils.isNotBlank(user.getName())) {
                predicates.add(cb.equal(root.get("name"), user.getName()));
            }
            if (StringUtils.isNotBlank(user.getMobile())) {
                predicates.add(cb.equal(root.get("mobile"), user.getMobile()));
            }
            if (StringUtils.isNotBlank(user.getTelephone())) {
                predicates.add(cb.equal(root.get("telephone"), user.getTelephone()));
            }
            if (StringUtils.isNotBlank(user.getEmail())) {
                predicates.add(cb.equal(root.get("email"), user.getEmail()));
            }
            if (Objects.nonNull(user.getStatus())) {
                predicates.add(cb.equal(root.get("status"), user.getStatus()));
            }
            if (StringUtils.isNotBlank(user.getApproveStatus())) {
                predicates.add(cb.equal(root.get("approvedStatus"), user.getApproveStatus()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}