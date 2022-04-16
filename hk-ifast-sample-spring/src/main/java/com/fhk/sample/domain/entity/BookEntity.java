package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Data
@TableName("book")
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
	 * 内容
	 */
	private String content;
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
