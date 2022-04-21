package com.fhk.sample.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@Data
@Table(name = "user")
@Entity
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * 角色
     */
    private String role;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 审核状态
     */
    @Column(name = "approve_status")
    private String approveStatus;
    /**
     * 创建时间
     */
    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdDate;
    /**
     * 更新时间
     */
    @Column(name = "updated_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedDate;
    /**
     * 审批时间
     */
    @Column(name = "approved_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date approvedDate;
    /**
     * 审批人
     */
    @Column(name = "approved_by")
    private String approvedBy;
    /**
     * 重试次数
     */
    @Column(name = "number_of_retries")
    private Integer numberOfRetries;
    /**
     * 上次登录日期
     */
    @Column(name = "last_login_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastLoginDate;

}
