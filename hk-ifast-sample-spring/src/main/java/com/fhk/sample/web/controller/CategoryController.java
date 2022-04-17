package  com.fhk.sample.web.controller;
;

import java.util.Arrays;
import java.util.Map;

import com.fhk.sample.common.rest.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fhk.sample.domain.entity.Category;
import com.fhk.sample.service.CategoryService;

import javax.annotation.Resource;


/**
 * 分类
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/category")
public class CategoryController extends BaseController{
    @Resource
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public RestResponse<Void> list(@RequestParam Map<String, Object> params){
        return RestResponse.success();
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public RestResponse<Category> info(@PathVariable("id") Integer id){
        return RestResponse.success(categoryService.queryById(id));
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public RestResponse<Void> save(@RequestBody Category category){
        return RestResponse.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public RestResponse<Void> update(@RequestBody Category category){
        return RestResponse.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public RestResponse<Void> delete(@RequestBody Integer[] ids){
        return RestResponse.success();
    }

}
