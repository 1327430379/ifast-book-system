package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 支票
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Data
@TableName("cheque")
public class ChequeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
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
