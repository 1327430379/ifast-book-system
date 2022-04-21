//package com.fhk.sample.domain.entity;
package com.fhk.sample.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "account")
@Entity
public class Account  {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 状态：approved,pending
     */
    private String status;
    /**
     * 审核人
     */
    @Column(name = "approved_by")
    private String approvedBy;

    public Account() {

    }

    public Account(String username, BigDecimal balance, String status, String approvedBy) {
        this.username = username;
        this.status = status;
        this.balance = balance;
        this.approvedBy = approvedBy;
    }

}
