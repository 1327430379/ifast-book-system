package com.fhk.sample.service.impl;


import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.dao.AccountRepository;
import com.fhk.sample.domain.entity.Account;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.fhk.sample.common.constants.CommonConstants.APPROVE_APPROVED_STATUS;
import static com.fhk.sample.common.constants.CommonConstants.APPROVE_PENDING_STATUS;

/**
 * @author lingzan
 */
@Service
public class AccountServiceImpl  implements AccountService {

    @Resource
    private AccountRepository accountRepository;


    @Override
    public PageVO<Account> queryPage(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Account createAccountForUser(User user) {
        Account account = new Account(user.getUsername(), BigDecimal.ZERO, APPROVE_PENDING_STATUS,"");
        accountRepository.save(account);
        return account;
    }

    @Override
    public List<Account> list() {
        return accountRepository.findAll();
    }

    @Override
    public Account queryById(Integer id) {
        return accountRepository.findOne(id);
    }

    @Override
    public Account queryByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public void approve(String username) {
        User user = SessionManager.getCurrentUserSession();
        String approvedBy = Optional.ofNullable(user).map(User::getUsername).orElse("");
        accountRepository.updateApproveStatus(username,APPROVE_APPROVED_STATUS,approvedBy);
    }
}