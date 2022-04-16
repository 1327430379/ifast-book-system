package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 电话
	 */
	private String mobile;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createdDate;
	/**
	 * 更新时间
	 */
	private Date updatedDate;
	/**
	 * 审批时间
	 */
	private Date approvedDate;
	/**
	 * 审批人
	 */
	private String approvedBy;
	/**
	 * 重试次数
	 */
	private Integer numberOfRetries;
	/**
	 * 上次登录日期
	 */
	private Date lastLoginDate;

}
