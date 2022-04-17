package com.fhk.sample.service.impl;


import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.dao.AccountRepository;
import com.fhk.sample.domain.dao.UserRepository;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.AccountService;
import com.fhk.sample.service.UserService;
import com.fhk.sample.util.BizAssert;
import com.fhk.sample.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.fhk.sample.common.constants.CommonConstants.*;

/**
 * @author lingzan
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private AccountRepository accountRepository;
    @Resource
    private AccountService accountService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User register(User user) {
        User dbUser = userRepository.findByusername(user.getUsername());
        BizAssert.isNull(dbUser, "该用户名已存在");
        this.setCreateUserDefaultParam(user);
        User saveAfter = userRepository.save(user);
        accountService.createAccountForUser(saveAfter);
        return user;
    }


    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateById(User user) {
        checkUserAndGetUser(user.getId());
        return userRepository.save(user);
    }

    @Override
    public PageVO<User> listByPage(int pageNum, int pageSize, User user) {
        Sort sortBy = Sort.by(Sort.Order.desc("updatedDate"));
        Pageable pageable = PageRequest.of(pageNum, pageSize, sortBy);
        Specification<User> specification = getSpecification(user);
        Page<User> page = userRepository.findAll(specification, pageable);
        return PageUtil.convert(page);
    }



    @Override
    public void delete(Integer id) {
        userRepository.delete(checkUserAndGetUser(id));
    }

    @Override
    public void approve(Integer id) {
        User user = checkUserAndGetUser(id);
        if (APPROVE_PENDING_STATUS.equals(user.getApproveStatus())) {
            userRepository.updateApproveStatus(id, APPROVE_APPROVED_STATUS, new Date());
        } else {
            log.warn("当前用户已经通过审核,勿重复处理");
        }
    }

    @Override
    public void updateStatus(Integer id, Integer status) {
        checkUserAndGetUser(id);
        userRepository.updateStatus(id, status);
    }

    @Override
    public User login(String username, String password,String role) {
        User user = userRepository.findByusername(username);
        BizAssert.isNotNull(user,"用户名不存在");
        BizAssert.isTrue(password.equals(user.getPassword()),"密码不正确");
        BizAssert.isTrue(USER_ENABLE_STATUS.equals(user.getStatus()),"该用户已被禁用");
        userRepository.updateLastLoginDate(user.getId(),new Date());
        return user;
    }

    @Override
    public void logout(String username) {
        SessionManager.invalidate();
    }

    private User checkUserAndGetUser(Integer id) {
        User user = userRepository.getOne(id);
        BizAssert.isNotNull(user, "用户不存在");
        return user;
    }


    private void setCreateUserDefaultParam(User user) {
        user.setStatus(USER_ENABLE_STATUS);
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