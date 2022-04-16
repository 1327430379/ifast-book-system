package com.fhk.sample.service;

import com.fhk.sample.domain.dto.UserDTO;
import com.fhk.sample.domain.entity.User;



/**
 * @author lingzan
 */
public interface UserService {

    User register(User user);

    User getById(Integer id);

    User updateById(User user);
}

