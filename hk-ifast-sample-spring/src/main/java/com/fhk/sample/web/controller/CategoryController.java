package package com.fhk.sample.web.controller;
;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhk.sample.domain.entity.Category;
import com.fhk.sample.service.CategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 分类
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:category:info")
    public R info(@PathVariable("id") Integer id){
		Category category = categoryService.getById(id);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:category:save")
    public R save(@RequestBody Category category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:category:update")
    public R update(@RequestBody Category category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:category:delete")
    public R delete(@RequestBody Integer[] ids){
		categoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
