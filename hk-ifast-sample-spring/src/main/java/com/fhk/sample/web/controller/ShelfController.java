 package com.fhk.sample.web.controller;

import java.util.Arrays;
import java.util.Map;


/**
 * 用户已购买书籍表
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/shelf")
public class ShelfController {
    @Autowired
    private ShelfService shelfService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:shelf:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shelfService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:shelf:info")
    public R info(@PathVariable("id") Integer id){
		ShelfEntity shelf = shelfService.getById(id);

        return R.ok().put("shelf", shelf);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:shelf:save")
    public R save(@RequestBody ShelfEntity shelf){
		shelfService.save(shelf);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:shelf:update")
    public R update(@RequestBody ShelfEntity shelf){
		shelfService.updateById(shelf);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:shelf:delete")
    public R delete(@RequestBody Integer[] ids){
		shelfService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
