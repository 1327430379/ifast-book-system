package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.Cheque;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 支票
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Repository
public interface ChequeRepository extends JpaRepository<Cheque,Integer>, JpaSpecificationExecutor<Cheque> {
	
}
