package com.fhk.sample.service;

import com.fhk.sample.domain.entity.Cheque;
import com.fhk.sample.domain.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 支票
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface ChequeService  {

    PageVO<Cheque> queryPage(Map<String, Object> params);

    List<Cheque> list();

    void approve(Integer id);
}

