package com.fhk.sample.service.impl;


import com.fhk.sample.common.exception.BusinessException;
import com.fhk.sample.domain.dao.AccountDao;
import com.fhk.sample.domain.dao.UserRepository;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author lingzan
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private AccountDao accountDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User register(User user) {
        return null;
    }

    @Override
    public User getById(Integer id) {
        return getByIdPrivate(id).orElse(null);
    }

    @Override
    public User updateById(User user) {
        this.getByIdPrivate(user.getId()).orElseThrow(()->new BusinessException("用户不存在"));
        return userRepository.save(user);
    }

    private Optional<User> getByIdPrivate(Integer id) {
        return userRepository.findById(id);
    }
}