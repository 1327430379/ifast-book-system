package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.AuthorEntity;
import io.renren.modules.generator.service.AuthorService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 作者表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:author:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = authorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:author:info")
    public R info(@PathVariable("id") Integer id){
		AuthorEntity author = authorService.getById(id);

        return R.ok().put("author", author);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:author:save")
    public R save(@RequestBody AuthorEntity author){
		authorService.save(author);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:author:update")
    public R update(@RequestBody AuthorEntity author){
		authorService.updateById(author);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:author:delete")
    public R delete(@RequestBody Integer[] ids){
		authorService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
