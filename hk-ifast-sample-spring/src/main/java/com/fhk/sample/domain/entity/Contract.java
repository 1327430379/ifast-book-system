package com.fhk.sample.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 合同表
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "contract")
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	private Integer id;
	/**
	 * 合同编号
	 */
	private String contractNumber;
	/**
	 * 用户
	 */
	private String user;
	/**
	 * 图书id
	 */
	private Integer bookId;
	/**
	 * 交易id
	 */
	private Integer transId;
	/**
	 * 审批人
	 */
	private String approvedBy;
	/**
	 * approved pending
	 */
	private String status;
	/**
	 * 作废日期
	 */
	private Date voidedDate;
	/**
	 * 创建日期
	 */
	private Date createdDate;
	/**
	 * 更新日期
	 */
	private Date updatedDate;

}
