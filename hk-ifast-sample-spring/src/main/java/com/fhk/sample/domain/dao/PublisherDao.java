package com.fhk.sample.domain.dao;


import com.fhk.sample.domain.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 出版社
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */

public interface PublisherDao extends JpaRepository<Publisher,Integer> {
	
}
