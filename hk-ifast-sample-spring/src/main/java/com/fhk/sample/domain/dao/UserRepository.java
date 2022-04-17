package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 用户表
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    User findByusername(String username);

    @Modifying
    @Query("update User set approveStatus=:approveStatus,approvedDate=:approvedDate where id = :id")
    int updateApproveStatus(@Param("id") Integer id, @Param("status") String status, @Param("approvedDate")Date approvedDate);

    @Modifying
    @Query("update User set status=:status where id = :id")
    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    @Modifying
    @Query("update User set lastLoginDate=:lastLoginDate where id = :id")
    int updateLastLoginDate(@Param("id") Integer id,@Param("lastLoginDate")Date lastLoginDate);
}
