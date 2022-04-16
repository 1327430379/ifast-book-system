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

import io.renren.modules.generator.entity.ContractEntity;
import io.renren.modules.generator.service.ContractService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 合同表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:contract:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = contractService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:contract:info")
    public R info(@PathVariable("id") Integer id){
		ContractEntity contract = contractService.getById(id);

        return R.ok().put("contract", contract);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:contract:save")
    public R save(@RequestBody ContractEntity contract){
		contractService.save(contract);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:contract:update")
    public R update(@RequestBody ContractEntity contract){
		contractService.updateById(contract);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:contract:delete")
    public R delete(@RequestBody Integer[] ids){
		contractService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
