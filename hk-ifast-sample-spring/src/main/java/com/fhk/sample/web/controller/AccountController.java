package com.fhk.sample.web.controller;


import java.util.Arrays;
import java.util.Map;




/**
 * 
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:account:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:account:info")
    public R info(@PathVariable("id") Integer id){
		Account account = accountService.getById(id);

        return R.ok().put("account", account);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:account:save")
    public R save(@RequestBody Account account){
		accountService.save(account);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:account:update")
    public R update(@RequestBody Account account){
		accountService.updateById(account);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:account:delete")
    public R delete(@RequestBody Integer[] ids){
		accountService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
