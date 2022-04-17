package com.fhk.sample.domain.dao;


import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
	
}
