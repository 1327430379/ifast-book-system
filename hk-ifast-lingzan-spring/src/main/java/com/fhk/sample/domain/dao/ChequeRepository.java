package com.fhk.sample.domain.dao;

import com.fhk.sample.domain.entity.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 支票
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Integer>, JpaSpecificationExecutor<Cheque> {


    @Modifying
    @Query("update Cheque set status=?2,approvedBy=?3,approvedDate=now() where id=?1")
    void updateApproveStatus(@Param("id") Integer id, @Param("approveStatus") String status, @Param("approvedBy") String approvedBy);


    Cheque findByContractNumber(String contractNumber);
}
