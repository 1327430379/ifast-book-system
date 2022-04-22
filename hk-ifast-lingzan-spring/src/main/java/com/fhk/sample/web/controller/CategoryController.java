package com.fhk.sample.web.controller;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.dto.CategoryDTO;
import com.fhk.sample.domain.entity.Category;
import com.fhk.sample.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

;


/**
 * 分类
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("category")
public class CategoryController extends BaseController {
    @Resource
    private CategoryService categoryService;

    /**
     * 列表
     */
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RestResponse<List<Category>> listAll(@RequestParam(name = "name", required = false) String name) {
        return RestResponse.success(categoryService.list(name));
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public RestResponse<Category> info(@PathVariable("id") Integer id) {
        return RestResponse.success(categoryService.queryById(id));
    }

    /**
     * 保存
     */
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RestResponse<Category> add(@RequestBody @Validated(value = CategoryDTO.InsertGroup.class) CategoryDTO category) {
        return RestResponse.success(categoryService.add(this.convert(category, Category.class)));
    }

    /**
     * 修改
     */
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResponse<Category> update(@RequestBody @Validated(value = CategoryDTO.UpdateGroup.class) CategoryDTO category) {
        return RestResponse.success(categoryService.update(this.convert(category, Category.class)));
    }

    /**
     * 删除
     */
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
        return RestResponse.success();
    }

}
