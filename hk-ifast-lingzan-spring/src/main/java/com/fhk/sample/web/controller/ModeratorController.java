package com.fhk.sample.web.controller;// package com.fhk.sample.web.controller;
//
//import java.util.Arrays;
//import java.util.Map;
//
//
//
///**
// * 版主
// *
// * @author lingzan
// *
// * @date 2022-04-16 09:52:44
// */
//@RestController
//@RequestMapping("generator/moderator")
//public class ModeratorController {
//    @Autowired
//    private ModeratorService moderatorService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:moderator:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = moderatorService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:moderator:info")
//    public R info(@PathVariable("id") Integer id){
//		ModeratorEntity moderator = moderatorService.getById(id);
//
//        return R.ok().put("moderator", moderator);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:moderator:save")
//    public R save(@RequestBody ModeratorEntity moderator){
//		moderatorService.save(moderator);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:moderator:update")
//    public R update(@RequestBody ModeratorEntity moderator){
//		moderatorService.updateById(moderator);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:moderator:delete")
//    public R delete(@RequestBody Integer[] ids){
//		moderatorService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }
//
//}
