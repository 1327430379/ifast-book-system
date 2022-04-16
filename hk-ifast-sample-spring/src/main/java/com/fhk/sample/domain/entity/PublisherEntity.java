package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 出版社
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Data
@TableName("publisher")
public class PublisherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
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
