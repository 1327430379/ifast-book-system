package com.fhk.sample.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Author {

	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
