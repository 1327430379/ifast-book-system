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

    User findByUsername(String username);

    @Modifying
    @Query("update User u set u.approveStatus=?2,u.approvedDate=?3,u.approvedBy=?4 where u.id =?1")
    int updateApproveStatus(@Param("id") Integer id, @Param("status") String status,
                            @Param("approvedDate") Date approvedDate, @Param("approvedBy") String approvedBy);

    @Modifying
    @Query("update User set status=?2 where id =?1")
    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    @Modifying
    @Query("update User set lastLoginDate=?2 where id =?1")
    int updateLastLoginDate(@Param("id") Integer id, @Param("lastLoginDate") Date lastLoginDate);

    @Modifying
    @Query("update User set numberOfRetries = numberOfRetries + 1 where id =?1")
    int incrNumberOfRetires(@Param("userId") String username);

}
