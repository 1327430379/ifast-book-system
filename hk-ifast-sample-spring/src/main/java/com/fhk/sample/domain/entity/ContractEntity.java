package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 合同表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Data
@TableName("contract")
public class ContractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
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
