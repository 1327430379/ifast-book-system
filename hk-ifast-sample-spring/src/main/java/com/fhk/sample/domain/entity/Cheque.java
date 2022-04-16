package com.fhk.sample.domain.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.io.Serializable;
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
public class Cheque implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	private Integer id;
	/**
	 * 用户
	 */
	private String user;
	/**
	 * 合同编号
	 */
	private String contractNumber;
	/**
	 * 创建日期
	 */
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
	private Date approvedDate;

}
