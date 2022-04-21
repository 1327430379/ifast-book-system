package com.fhk.sample.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支票
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "cheque")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cheque implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 用户
	 */
	private String username;
	/**
	 * 合同编号
	 */
	private String contractNumber;
	/**
	 * 创建日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	/**
	 * 金额
	 */
	private BigDecimal amount;
	/**
	 * 状态 approved pending
	 */
	private String status;
	/**
	 * 审批人
	 */
	private String approvedBy;
	/**
	 * 审批时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date approvedDate;

}
