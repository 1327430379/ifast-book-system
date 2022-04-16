package com.fhk.sample.domain.dao;


import com.fhk.sample.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface BookDao extends JpaRepository<Book,Integer> {
	
}
