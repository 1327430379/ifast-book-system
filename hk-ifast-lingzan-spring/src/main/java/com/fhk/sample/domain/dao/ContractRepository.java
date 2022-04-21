package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 合同表
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer>, JpaSpecificationExecutor<Contract> {
    Contract findByContractNumber(String contractNumber);




}
