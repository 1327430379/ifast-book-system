package com.fhk.sample.service.impl;

import com.fhk.sample.common.constants.ContractStatus;
import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.dao.ChequeRepository;
import com.fhk.sample.domain.dao.ContractRepository;
import com.fhk.sample.domain.entity.Cheque;
import com.fhk.sample.domain.entity.Contract;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.ContractService;
import com.fhk.sample.util.BizAssert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Service("contractService")
public class ContractServiceImpl implements ContractService {

    @Resource
    private ContractRepository contractRepository;
    @Resource
    private ChequeRepository chequeRepository;

    @Override
    public PageVO<Contract> queryPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public Contract create(Contract contract) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void voiding(Integer id) {
        User user = SessionManager.getCurrentUserSession();
        Contract contract = contractRepository.findOne(id);
        BizAssert.isNotNull(contract, "合同不存在");
        BizAssert.isTrue(contract.getUsername().equals(user.getUsername()), "合同不存在");
        BizAssert.isTrue(!ContractStatus.PENDING.equals(contract.getStatus()), "操作无效");
        contract.setStatus(ContractStatus.VOID);
        contract.setVoidedDate(new Date());
        contractRepository.save(contract);

        //支票支付方式需要同步修改状态
        Cheque cheque = chequeRepository.findByContractNumber(contract.getContractNumber());
        cheque.setStatus(ContractStatus.VOID);
        chequeRepository.save(cheque);
    }
}