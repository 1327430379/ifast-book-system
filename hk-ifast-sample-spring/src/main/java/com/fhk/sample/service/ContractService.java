package com.fhk.sample.service;

import java.util.Map;

/**
 * 合同表
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface ContractService {

    PageUtils queryPage(Map<String, Object> params);
}

