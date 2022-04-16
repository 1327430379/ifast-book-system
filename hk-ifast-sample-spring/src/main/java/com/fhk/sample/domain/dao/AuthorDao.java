package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 作者表
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface AuthorDao extends JpaRepository<Author,Integer> {
	
}
