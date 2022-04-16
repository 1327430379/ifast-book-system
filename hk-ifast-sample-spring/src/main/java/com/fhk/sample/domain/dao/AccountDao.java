package com.fhk.sample.domain.dao;
import com.fhk.sample.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface AccountDao extends JpaRepository<Account,Integer> {
	
}
