package com.fhk.sample.web.controller;


import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.vo.PageVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhk.sample.domain.entity.Author;
import com.fhk.sample.service.AuthorService;

import javax.annotation.Resource;


/**
 * 作者表
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("author")
public class AuthorController extends BaseController{

    @Resource
    private AuthorService authorService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    public RestResponse<PageVO<Author>> queryByPage(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                    @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize,
                                                    @RequestParam(name = "name", required = false) String name,
                                                    @RequestParam(name = "country", required = false) String country) {
        Author author = Author.builder().name(name).country(country).build();
        return RestResponse.success(authorService.queryPage(pageNum, pageSize, author));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public RestResponse<Author> info(@PathVariable("id") Integer id) {
        Author author = authorService.queryById(id);
        return RestResponse.success(author);
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public RestResponse<Author> add(@RequestBody @Validated Author author) {
        return RestResponse.success(authorService.add(author));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public RestResponse<Author> update(@RequestBody @Validated Author author) {
        return RestResponse.success(authorService.update(author));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        authorService.deleteById(id);
        return RestResponse.success();
    }

}
