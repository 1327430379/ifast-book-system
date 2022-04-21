package com.fhk.sample.service.impl;

import com.fhk.sample.common.constants.ContractStatus;
import com.fhk.sample.common.module.SessionManager;
import com.fhk.sample.domain.dao.ChequeRepository;
import com.fhk.sample.domain.dao.ContractRepository;
import com.fhk.sample.domain.entity.Cheque;
import com.fhk.sample.domain.entity.Contract;
import com.fhk.sample.domain.entity.User;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.ChequeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("chequeService")
public class ChequeServiceImpl  implements ChequeService {
    @Resource
    private ChequeRepository chequeRepository;
    @Resource
    private ContractRepository contractRepository;

    @Override
    public PageVO<Cheque> queryPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<Cheque> list() {
        return chequeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void approve(Integer id) {
        User currentUser = SessionManager.getCurrentUserSession();
        Cheque cheque = chequeRepository.findOne(id);
        chequeRepository.updateApproveStatus(id, ContractStatus.APPROVED,currentUser.getUsername());
        Contract contract = contractRepository.findByContractNumber(cheque.getContractNumber());
        contract.setApprovedBy(currentUser.getUsername());
        contract.setStatus(ContractStatus.APPROVED);
        contractRepository.save(contract);
    }
}