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

import io.renren.modules.generator.entity.PublisherEntity;
import io.renren.modules.generator.service.PublisherService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 出版社
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:publisher:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = publisherService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:publisher:info")
    public R info(@PathVariable("id") Integer id){
		PublisherEntity publisher = publisherService.getById(id);

        return R.ok().put("publisher", publisher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:publisher:save")
    public R save(@RequestBody PublisherEntity publisher){
		publisherService.save(publisher);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:publisher:update")
    public R update(@RequestBody PublisherEntity publisher){
		publisherService.updateById(publisher);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:publisher:delete")
    public R delete(@RequestBody Integer[] ids){
		publisherService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}