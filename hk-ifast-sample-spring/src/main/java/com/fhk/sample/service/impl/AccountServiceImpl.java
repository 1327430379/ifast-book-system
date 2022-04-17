package com.fhk.sample.service.impl;


import com.fhk.sample.domain.dao.AccountRepository;
import com.fhk.sample.domain.entity.Account;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

import static com.fhk.sample.common.constants.CommonConstants.*;

/**
 * @author lingzan
 */
@Service
public class AccountServiceImpl  implements AccountService {

    @Resource
    private AccountRepository accountRepository;

    @Override
    public PageVO<Account> queryPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public Account createAccountForUser(User user) {
        Account account = new Account(user.getUsername(), BigDecimal.ZERO, APPROVE_PENDING_STATUS,"");
        accountRepository.save(account);
        return account;
    }


}