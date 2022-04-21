package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Contract;
import com.fhk.sample.domain.vo.PageVO;

import java.util.Map;

/**
 * 合同表
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface ContractService {

    PageVO<Contract> queryPage(Map<String, Object> params);

    Contract create(Contract contract);

    void voiding(Integer id);
}

