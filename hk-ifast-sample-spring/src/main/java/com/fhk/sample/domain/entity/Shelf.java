package com.fhk.sample.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户书架
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "shelf")
public class Shelf implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	private Integer id;
	/**
	 * 图书id
	 */
	private Integer bookId;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 上次访问日期
	 */
	private Date lastAccessDate;
	/**
	 * 阅读次数
	 */
	private Integer numberOfAccess;

}
