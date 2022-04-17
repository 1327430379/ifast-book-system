package com.fhk.sample.domain.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;


/**
 * 作者表
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "author")
@Builder
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
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
	 * 国家
	 */
	private String country;

}
