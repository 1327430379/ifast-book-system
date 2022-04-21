package com.fhk.sample.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class PublisherDTO {

    /**
     * 主键id
     */
    @NotNull(message = "id required",groups = UpdateGroup.class)
    private Integer id;
    /**
     * 名称
     */
    @NotBlank(message = "出版社名称不能为空",groups = InsertGroup.class)
    private String name;
    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱地址不能为空",groups = InsertGroup.class)
    private String email;
    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空",groups = InsertGroup.class)
    private String address;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空",groups = InsertGroup.class)
    private String telephone;
    /**
     * 传真
     */
    private String fax;

    public interface InsertGroup{};
    public interface UpdateGroup{};

}
