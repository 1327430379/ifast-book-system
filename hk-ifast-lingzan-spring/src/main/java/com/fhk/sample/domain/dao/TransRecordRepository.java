package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.TransRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransRecordRepository extends JpaRepository<TransRecord,Integer> {

    List<TransRecord> findAllByAccountId(Integer accountId);
}
