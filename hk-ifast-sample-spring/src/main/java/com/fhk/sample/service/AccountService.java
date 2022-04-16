package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Account;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * 
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface AccountService  {

    Page<Account> queryPage(Map<String, Object> params);
}

