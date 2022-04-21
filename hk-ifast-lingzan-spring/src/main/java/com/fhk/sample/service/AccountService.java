package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Account;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;

import java.util.List;

/**
 * 
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface AccountService  {

    PageVO<Account> queryPage(Integer pageNum, Integer pageSize);

    Account createAccountForUser(User user);

    List<Account> list();

    Account queryById(Integer id);

    Account queryByUsername(String username);

    void approve(String username);
}

