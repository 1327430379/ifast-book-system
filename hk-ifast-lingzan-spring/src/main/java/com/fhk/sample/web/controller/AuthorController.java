package com.fhk.sample.web.controller;


import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Author;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.AuthorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 作者表
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("author")
public class AuthorController extends BaseController {

    @Resource
    private AuthorService authorService;

    /**
     * 分页
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public RestResponse<PageVO<Author>> queryByPage(@RequestParam(name = "pageNum", defaultValue = "0", required = false) Integer pageNum,
                                                    @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize,
                                                    @RequestParam(name = "name", required = false) String name,
                                                    @RequestParam(name = "country", required = false) String country) {
        Author author = Author.builder().name(name).country(country).build();
        return RestResponse.success(authorService.queryPage(pageNum, pageSize, author));
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RestResponse<List<Author>> listAll() {
        return RestResponse.success(authorService.listAll());
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public RestResponse<Author> info(@PathVariable("id") Integer id) {
        Author author = authorService.queryById(id);
        return RestResponse.success(author);
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RestResponse<Author> add(@RequestBody @Validated Author author) {
        return RestResponse.success(authorService.add(author));
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResponse<Author> update(@RequestBody @Validated Author author) {
        return RestResponse.success(authorService.update(author));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        authorService.deleteById(id);
        return RestResponse.success();
    }

}
