package com.fhk.sample.service.impl;

import com.fhk.sample.common.constants.ContractStatus;
import com.fhk.sample.common.constants.PaymentMode;
import com.fhk.sample.common.constants.TransType;
import com.fhk.sample.domain.dao.AccountRepository;
import com.fhk.sample.domain.dao.ContractRepository;
import com.fhk.sample.domain.dao.TransRecordRepository;
import com.fhk.sample.domain.entity.*;
import com.fhk.sample.service.ContractService;
import com.fhk.sample.service.PaymentService;
import com.fhk.sample.util.BizAssert;
import com.fhk.sample.util.BizNoGenerator;
import com.fhk.sample.util.BizNoPrefix;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Primary
@Service("cashPaymentService")
public class CashPaymentServiceImpl implements PaymentService {

    @Resource
    private AccountRepository accountRepository;
    @Resource
    private TransRecordRepository transRecordRepository;
    @Resource
    private ContractService contractService;
    @Resource
    private ContractRepository contractRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pay(User user, Book book) {
        Account account = accountRepository.findByUsername(user.getUsername());
        BizAssert.isTrue(account.getBalance().compareTo(book.getPrice())>=0,"账户余额不足");

        TransRecord transRecord = TransRecord.builder()
                .amount(book.getPrice().multiply(new BigDecimal(-1)))
                .status(ContractStatus.PENDING)
                .username(user.getUsername())
                .accountId(account.getId())
                .createdDate(new Date())
                .transType(TransType.EXPEND)
                .transNumber(BizNoGenerator.generate(BizNoPrefix.BB)).build();
        transRecordRepository.save(transRecord);

        accountRepository.updateBalance(account.getId(),account.getBalance().subtract(book.getPrice()));

        Date currentDate = new Date();
        Contract contract = Contract.builder()
                .status(ContractStatus.APPROVED)
//                .transRecord(transRecord)
                .bookId(book.getId())
                .transNumber(transRecord.getTransNumber())
                .transId(transRecord.getId())
                .amount(transRecord.getAmount())
                .contractNumber(BizNoGenerator.generate(BizNoPrefix.BB))
                .username(user.getUsername())
                .paymentMode(PaymentMode.CASH.getType())
                .createdDate(currentDate)
                .updatedDate(currentDate)
                .build();

        contractRepository.save(contract);
    }
}
