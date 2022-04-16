package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户已购买书籍表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Data
@TableName("shelf")
public class ShelfEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
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
