package com.fhk.sample.web.controller;

import java.util.Arrays;
import java.util.Map;

import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.service.BookService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:book:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bookService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:book:info")
    public R info(@PathVariable("id") Integer id){
		Book book = bookService.getById(id);

        return R.ok().put("book", book);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:book:save")
    public R save(@RequestBody Book book){
		bookService.save(book);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:book:update")
    public R update(@RequestBody Book book){
		bookService.updateById(book);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:book:delete")
    public R delete(@RequestBody Integer[] ids){
		bookService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
