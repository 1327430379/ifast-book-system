package com.fhk.sample.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Author: 凌瓒
 * @Date: 2022/04/17/12:12 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    @NotNull(message = "id required",groups = UpdateGroup.class)
    private Integer id;

    @NotBlank(message = "分类名称不能为空",groups = InsertGroup.class)
    private String name;

    @NotBlank(message = "描述不能为空",groups = InsertGroup.class)
    private String description;

    public interface InsertGroup{};
    public interface UpdateGroup{};
}
