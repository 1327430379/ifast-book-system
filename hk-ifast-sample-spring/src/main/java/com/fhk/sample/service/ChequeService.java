package com.fhk.sample.service;

import java.util.Map;

/**
 * 支票
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface ChequeService  {

    PageUtils queryPage(Map<String, Object> params);
}

