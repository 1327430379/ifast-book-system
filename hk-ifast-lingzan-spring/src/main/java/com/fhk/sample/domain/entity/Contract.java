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
 * 合同表
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "contract")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 合同编号
	 */
	private String contractNumber;
	/**
	 * 用户
	 */
	private String username;
	/**
	 * 图书id
	 */
	private Integer bookId;
//
//	@OneToOne
//	@JoinColumn(name = "trans_number")
//	private TransRecord transRecord;
	/**
	 * 交易id
	 */
	private Integer transId;

	/**
	 * 交易号
	 */
	private String transNumber;

	/**
	 * 交易金额
	 */
	private BigDecimal amount;

	/**
	 * 审批人
	 */
	private String approvedBy;
	/**
	 * approved pending void
	 */
	private String status;

	/**
	 * 支付方式
	 */
	private String paymentMode;
	/**
	 * 作废日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date voidedDate;
	/**
	 * 创建日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	/**
	 * 更新日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;

}
