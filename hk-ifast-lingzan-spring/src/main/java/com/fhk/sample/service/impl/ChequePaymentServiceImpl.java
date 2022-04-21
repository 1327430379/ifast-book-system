package com.fhk.sample.service.impl;

import com.fhk.sample.common.constants.ContractStatus;
import com.fhk.sample.common.constants.PaymentMode;
import com.fhk.sample.common.constants.TransType;
import com.fhk.sample.domain.dao.AccountRepository;
import com.fhk.sample.domain.dao.ChequeRepository;
import com.fhk.sample.domain.dao.ContractRepository;
import com.fhk.sample.domain.dao.TransRecordRepository;
import com.fhk.sample.domain.entity.*;
import com.fhk.sample.service.PaymentService;
import com.fhk.sample.util.BizNoGenerator;
import com.fhk.sample.util.BizNoPrefix;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;


@Service("chequePaymentService")
public class ChequePaymentServiceImpl implements PaymentService {

    @Resource
    private AccountRepository accountRepository;
    @Resource
    private TransRecordRepository transRecordRepository;
    @Resource
    private ChequeRepository chequeRepository;
    @Resource
    private ContractRepository contractRepository;

    @Override
    public void pay(User user, Book book) {
        Account account = accountRepository.findByUsername(user.getUsername());

        TransRecord transRecord = TransRecord.builder()
                .amount(book.getPrice().multiply(new BigDecimal(-1)))
                .username(user.getUsername())
                .accountId(account.getId())
                .createdDate(new Date())
                .transType(TransType.EXPEND)
                .status(ContractStatus.APPROVED)
                .transNumber(BizNoGenerator.generate(BizNoPrefix.TTN)).build();


        Date currentDate = new Date();
        Contract contract = Contract.builder()
                .status(ContractStatus.PENDING)
                .bookId(book.getId())
//                .transRecord(transRecord)
                .transId(transRecord.getId())
                .transNumber(transRecord.getTransNumber())
                .contractNumber(BizNoGenerator.generate(BizNoPrefix.BB))
                .amount(transRecord.getAmount())
                .username(user.getUsername())
                .createdDate(currentDate)
                .paymentMode(PaymentMode.CHEQUE.getType())
                .updatedDate(currentDate)
                .build();

        Cheque cheque = Cheque.builder()
                .contractNumber(contract.getContractNumber())
                .username(user.getUsername())
                .createdDate(new Date())
                .status(ContractStatus.PENDING)
                .amount(book.getPrice())
                .build();
        transRecordRepository.save(transRecord);
        contractRepository.save(contract);
        chequeRepository.save(cheque);
    }
}
