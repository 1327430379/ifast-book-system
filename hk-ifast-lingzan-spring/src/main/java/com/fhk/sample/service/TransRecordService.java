package com.fhk.sample.service;

import com.fhk.sample.domain.entity.TransRecord;

import java.util.List;

public interface TransRecordService {

    List<TransRecord> queryByAccountId(Integer accountId);

    TransRecord add(TransRecord transRecord);

    void deleteById(Integer id);

    TransRecord queryById(Integer id);
}
