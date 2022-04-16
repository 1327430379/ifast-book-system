package com.fhk.sample.domain.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 出版社
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "publisher")
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	private Integer id;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 传真
	 */
	private String fax;

}
