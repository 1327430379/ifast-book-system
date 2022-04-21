package com.fhk.sample.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 分类
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "category")
@Entity
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

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
	 * 描述
	 */
	private String description;

}
