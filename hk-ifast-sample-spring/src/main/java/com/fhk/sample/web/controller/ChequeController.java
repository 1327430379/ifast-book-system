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

import io.renren.modules.generator.entity.ChequeEntity;
import io.renren.modules.generator.service.ChequeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 支票
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/cheque")
public class ChequeController {
    @Autowired
    private ChequeService chequeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:cheque:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chequeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:cheque:info")
    public R info(@PathVariable("id") Integer id){
		ChequeEntity cheque = chequeService.getById(id);

        return R.ok().put("cheque", cheque);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:cheque:save")
    public R save(@RequestBody ChequeEntity cheque){
		chequeService.save(cheque);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:cheque:update")
    public R update(@RequestBody ChequeEntity cheque){
		chequeService.updateById(cheque);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:cheque:delete")
    public R delete(@RequestBody Integer[] ids){
		chequeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
