package com.fhk.sample.domain.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 版主
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "moderator")
public class Moderator implements Serializable {
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
	 * 启用状态：1、启用，0、禁用
	 */
	private Integer enable;
	/**
	 * 上次登录日期
	 */
	private Date lastLoginDate;

}
