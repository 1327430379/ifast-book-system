//package com.fhk.sample.domain.entity;
package com.fhk.sample.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
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
