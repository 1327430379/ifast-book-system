package com.fhk.sample.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户书架
 * 
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "shelf")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shelf implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 图书id
	 */
	@OneToOne
	@JoinColumn(name = "book_id")
	private Book book;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 上次访问日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastAccessDate;
	/**
	 * 阅读次数
	 */
	private Integer numberOfAccess;

}
