package  com.fhk.sample.web.controller;


import java.util.Arrays;
import java.util.Map;



/**
 * 合同表
 *
 * @author lingzan
 * 
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
