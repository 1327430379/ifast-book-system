package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    Account findByUsername(String username);

    @Modifying
    @Query("update  Account set status=?2,approvedBy=?3 where username = ?1")
    void updateApproveStatus(@Param("username") String username, @Param("status") String status, @Param("approvedBy") String approvedBy);

    @Modifying
    @Query("update Account  set balance = ?2 where id=?1")
    void updateBalance(@Param("id") Integer id, @Param("amount") BigDecimal Balance);

}
