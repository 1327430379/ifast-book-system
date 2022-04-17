package com.fhk.sample.domain.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "user")
@Entity
public class User implements Serializable {
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
	 * 密码
	 */
	private String password;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 电话
	 */
	private String mobile;
	/**
	 * 地址
	 */
	private String address;

	/**
	 * 角色
	 */
	private String role;
	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 审核状态
	 */
	private String approveStatus;
	/**
	 * 创建时间
	 */
	private Date createdDate;
	/**
	 * 更新时间
	 */
	private Date updatedDate;
	/**
	 * 审批时间
	 */
	private Date approvedDate;
	/**
	 * 审批人
	 */
	private String approvedBy;
	/**
	 * 重试次数
	 */
	private Integer numberOfRetries;
	/**
	 * 上次登录日期
	 */
	private Date lastLoginDate;

}
