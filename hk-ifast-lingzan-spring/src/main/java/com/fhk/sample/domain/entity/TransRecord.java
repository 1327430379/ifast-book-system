package com.fhk.sample.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "trans_record")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransRecord {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 交易号
     */
    @Column(name = "trans_number")
    private String transNumber;

    /**
     * 交易类型
     */
    @Column(name = "trans_type")
    private String transType;

    /**
     * 账户id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建日期
     */
    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;


}
