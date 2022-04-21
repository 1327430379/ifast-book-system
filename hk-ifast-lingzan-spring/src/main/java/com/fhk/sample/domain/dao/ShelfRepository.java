package com.fhk.sample.domain.dao;


import com.fhk.sample.domain.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户已购买书籍表
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Integer>, JpaSpecificationExecutor<Shelf> {

    List<Shelf> findAllByUserId(Integer userId);
}
