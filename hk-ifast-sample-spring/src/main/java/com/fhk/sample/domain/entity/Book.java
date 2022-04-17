package com.fhk.sample.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "book")
@Builder
@NoArgsConstructor
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 学科
	 */
	private String subject;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * ISBN
	 */
	private String isbn;
	/**
	 * 内容存放路径
	 */
	private String path;
	/**
	 * 内容类型:pdf,txt
	 */
	private String contentType;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 分类
	 */
	private String category;
	/**
	 * 出版社
	 */
	private String publisher;
	/**
	 * 文件大小
	 */
	private Double size;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 创建日期
	 */
	private Date createdDate;
	/**
	 * 更新日期
	 */
	private Date updatedDate;

}
