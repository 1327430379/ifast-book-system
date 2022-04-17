package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.Author;
import com.fhk.sample.domain.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 作者表
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface AuthorRepository extends JpaRepository<Author,Integer>, JpaSpecificationExecutor<Author> {
	
}
