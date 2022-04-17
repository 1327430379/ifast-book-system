package com.fhk.sample.domain.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank
    private String username;
    /**
     * 密码
     */
    @NotBlank(groups = InsertGroup.class)
    private String password;
    /**
     * 名字
     */
    @NotBlank(groups = InsertGroup.class)
    private String name;
    /**
     * 邮箱
     */
    @NotBlank(groups = InsertGroup.class)
    private String email;
    /**
     * 手机号
     */
    @NotBlank(groups = InsertGroup.class)
    private String telephone;
    /**
     * 电话
     */
    @NotBlank(groups = InsertGroup.class)
    private String mobile;
    /**
     * 地址
     */
    @NotBlank(groups = InsertGroup.class)
    private String address;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 角色
     */
    @NotBlank(groups = InsertGroup.class)
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
