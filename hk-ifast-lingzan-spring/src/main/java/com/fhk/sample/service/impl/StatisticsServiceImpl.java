package com.fhk.sample.service.impl;

import com.fhk.sample.common.constants.ContractStatus;
import com.fhk.sample.common.constants.PaymentMode;
import com.fhk.sample.domain.dao.ContractRepository;
import com.fhk.sample.domain.dto.StatisticsDTO;
import com.fhk.sample.domain.entity.Contract;
import com.fhk.sample.service.StatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Resource
    private ContractRepository contractRepository;


    @Override
    public StatisticsDTO show() {
        StatisticsDTO statistics = new StatisticsDTO();
        //总金额
        BigDecimal totalCash = BigDecimal.ZERO;
        int totalVoidedContract = 0;
        int totalCompletedContract = 0;
        List<Contract> contracts = contractRepository.findAll();

        for (Contract contract : contracts) {
            if (PaymentMode.CASH.getType().equals(contract.getPaymentMode())) {
                totalCash = totalCash.add(contract.getAmount());
            }
            if (ContractStatus.VOID.equals(contract.getStatus())) {
                totalVoidedContract++;
            }
            totalCompletedContract++;
        }
        statistics.setTotalCash(totalCash);
        statistics.setTotalVoidedContract(totalVoidedContract);
        statistics.setTotalCompletedContract(totalCompletedContract);
        return statistics;
    }
}
