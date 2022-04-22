package com.fhk.sample.service.impl;

import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.dao.UserRepository;
import com.fhk.sample.domain.dto.LoginUser;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.service.UserService;
import com.fhk.sample.util.BizAssert;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

import static com.fhk.sample.common.constants.CommonConstants.APPROVE_APPROVED_STATUS;
import static com.fhk.sample.common.constants.CommonConstants.USER_ENABLE_STATUS;
import static com.fhk.sample.common.constants.ExceptionCode.PASSWORD_INPUT_ERROR;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        BizAssert.isNotNull(user, "用户名不存在");
        BizAssert.isTrue(APPROVE_APPROVED_STATUS.equals(user.getApproveStatus()), "该用户还未审核通过");
        BizAssert.isTrue(USER_ENABLE_STATUS.equals(user.getStatus()), "该用户已被禁用");
//        BizAssert.isTrue(role.equals(user.getRole()), "角色不匹配");

        return new LoginUser(user);
    }
}
