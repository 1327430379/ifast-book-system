package com.fhk.sample.domain.dao;


import com.fhk.sample.domain.entity.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 版主
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */

public interface ModeratorRepository extends JpaRepository<Moderator,Integer> {
	
}
