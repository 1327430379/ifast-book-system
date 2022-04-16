package com.fhk.sample.domain.dao;


import com.fhk.sample.domain.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户已购买书籍表
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
public interface ShelfDao extends JpaRepository<Shelf, Integer> {

}
