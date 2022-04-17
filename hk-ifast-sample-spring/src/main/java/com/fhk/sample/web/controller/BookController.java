package com.fhk.sample.web.controller;

import java.util.Arrays;
import java.util.Map;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/book")
public class BookController extends BaseController {

    @Resource
    private BookService bookService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    public RestResponse<PageVO<Book>> queryByPage(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                  @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize,
                                                  @RequestParam("subject") String subject,
                                                  @RequestParam("author") String author,
                                                  @RequestParam("category") String category,
                                                  @RequestParam("publisher") String publisher,
                                                  @RequestParam("contentType") String contentType) {
        Book criteria = Book.builder()
                .subject(subject)
                .author(author)
                .category(category)
                .publisher(publisher)
                .contentType(contentType)
                .build();
        return RestResponse.success(bookService.queryPage(pageNum, pageSize, criteria));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public RestResponse<Book> info(@PathVariable("id") Integer id) {
        return RestResponse.success(bookService.queryById(id));
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public RestResponse<Book> save(@RequestBody Book book) {
        return RestResponse.success(bookService.save(book));
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public RestResponse<Book> update(@RequestBody Book book) {
        return RestResponse.success(bookService.update(book));

    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public RestResponse<Void> delete(@PathVariable("id")Integer id) {
        bookService.deleteById(id);
        return RestResponse.success();
    }

}
