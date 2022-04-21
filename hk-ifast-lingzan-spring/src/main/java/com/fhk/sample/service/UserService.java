package com.fhk.sample.service;

import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;


/**
 * @author lingzan
 */
public interface UserService {

    User register(User user);

    User getById(Integer id);

    User updateById(User user);

    PageVO<User> listByPage(int pageNum, int pageSize, User user);

    void delete(Integer id);

    void approve(Integer id);

    void updateStatus(Integer id, Integer status);

    User login(String username, String password, String role);

    void logout(String username);

    void incrRetries(Integer userId);
}

