package com.fhk.sample.service.impl;

import com.fhk.sample.common.constants.CommonConstants;
import com.fhk.sample.common.constants.TransType;
import com.fhk.sample.domain.dao.AccountRepository;
import com.fhk.sample.domain.dao.TransRecordRepository;
import com.fhk.sample.domain.entity.Account;
import com.fhk.sample.domain.entity.TransRecord;
import com.fhk.sample.service.TransRecordService;
import com.fhk.sample.util.BizNoGenerator;
import com.fhk.sample.util.BizNoPrefix;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransRecordServiceImpl implements TransRecordService {

    @Resource
    private TransRecordRepository transRecordRepository;
    @Resource
    private AccountRepository accountRepository;

    @Override
    public List<TransRecord> queryByAccountId(Integer accountId) {
        return transRecordRepository.findAllByAccountId(accountId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransRecord add(TransRecord transRecord) {
        transRecord.setTransNumber(BizNoGenerator.generate(BizNoPrefix.TTN));
        transRecord.setStatus(CommonConstants.APPROVE_APPROVED_STATUS);
        transRecord.setTransType(TransType.RECHARGE);
        transRecordRepository.save(transRecord);
        Account account = accountRepository.findOne(transRecord.getAccountId());
        accountRepository.updateBalance(account.getId(), account.getBalance().add(transRecord.getAmount()));
        return transRecord;
    }

    @Override
    public void deleteById(Integer id) {
        transRecordRepository.delete(id);
    }

    @Override
    public TransRecord queryById(Integer id) {
        return transRecordRepository.findOne(id);
    }
}
