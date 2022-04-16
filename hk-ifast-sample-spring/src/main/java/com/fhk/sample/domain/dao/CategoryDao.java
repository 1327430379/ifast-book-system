package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 分类
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */

public interface CategoryDao extends JpaRepository<Category,Integer> {
	
}
