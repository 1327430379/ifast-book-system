package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户表
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


}
