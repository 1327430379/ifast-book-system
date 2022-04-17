package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Account;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
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

    PageVO<Account> queryPage(Map<String, Object> params);

    Account createAccountForUser(User user);
}

