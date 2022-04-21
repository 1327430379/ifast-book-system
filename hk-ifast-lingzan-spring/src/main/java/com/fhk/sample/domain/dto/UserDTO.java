package com.fhk.sample.domain.dto;

import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/16/11:24 上午
 */
@Data
public class UserDTO {

    @NotNull(groups = UpdateGroup.class)
    private Integer id;
    /**
     * 用户名
     */
    @NotBlank(groups = InsertGroup.class,message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotBlank(groups = InsertGroup.class, message = "密码不能为空")
    private String password;
    /**
     * 名字
     */
    @NotBlank(groups = InsertGroup.class,message = "名称不能为空")
    private String name;
    /**
     * 邮箱
     */
    @NotBlank(groups = InsertGroup.class,message = "邮件不能为空")
    @Pattern(regexp = "[A-Za-z0-9]+([_\\.][A-Za-z0-9]+)*",message = "邮箱格式有误")
    private String email;
    /**
     * 电话
     */
    @NotBlank(groups = InsertGroup.class,message = "电话不能为空")
    private String telephone;
    /**
     * 手机号
     */
    @NotBlank(groups = InsertGroup.class,message = "手机号不能为空")
    @Pattern(regexp = "/^1[3456789]\\d{9}$/",message = "手机号格式有误")
    private String mobile;
    /**
     * 地址
     */
    @NotBlank(groups = InsertGroup.class,message = "地址不能为空")
    private String address;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 角色
     */
    @NotBlank(groups = InsertGroup.class, message = "role can not be empty")
    private String role;

    /**
     * 审批时间
     */
    @Getter
    private Date approvedDate;
    /**
     * 审批人
     */
    @Getter
    private String approvedBy;
    /**
     * 重试次数
     */
    @Getter
    private Integer numberOfRetries;
    /**
     * 上次登录日期
     */
    @Getter
    private Date lastLoginDate;

    public interface InsertGroup {
    }

    public interface UpdateGroup {
    }


}
