package com.fhk.sample.domain.dao;


import com.fhk.sample.domain.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 出版社
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>, JpaSpecificationExecutor<Publisher> {

}
