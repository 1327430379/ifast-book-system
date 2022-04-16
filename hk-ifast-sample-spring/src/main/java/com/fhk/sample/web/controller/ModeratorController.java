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

import io.renren.modules.generator.entity.ModeratorEntity;
import io.renren.modules.generator.service.ModeratorService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 版主
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/moderator")
public class ModeratorController {
    @Autowired
    private ModeratorService moderatorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:moderator:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = moderatorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:moderator:info")
    public R info(@PathVariable("id") Integer id){
		ModeratorEntity moderator = moderatorService.getById(id);

        return R.ok().put("moderator", moderator);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:moderator:save")
    public R save(@RequestBody ModeratorEntity moderator){
		moderatorService.save(moderator);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:moderator:update")
    public R update(@RequestBody ModeratorEntity moderator){
		moderatorService.updateById(moderator);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:moderator:delete")
    public R delete(@RequestBody Integer[] ids){
		moderatorService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
