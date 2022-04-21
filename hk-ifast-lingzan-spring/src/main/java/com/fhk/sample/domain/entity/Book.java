package com.fhk.sample.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
@AllArgsConstructor
@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Column(name = "content_type")
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
	 * 庫存
	 */
	private Integer stock;
	/**
	 * 创建日期
	 */
	@Column(name = "created_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	/**
	 * 更新日期
	 */
	@Column(name = "updated_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;

}
