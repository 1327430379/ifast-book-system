package com.fhk.sample.web.controller;

import com.fhk.sample.common.constants.PaymentMode;
import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.dto.BookDTO;
import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.BookService;
import com.fhk.sample.service.UploadService;
import com.fhk.sample.util.BizAssert;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("book")
public class BookController extends BaseController {

    @Resource
    private BookService bookService;
    @Resource
    private UploadService uploadService;

    /**
     * 分頁查詢
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
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
     * 列表查詢
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RestResponse<List<Book>> list(
            @RequestParam(name = "subject", required = false) String subject,
            @RequestParam(name = "author", required = false) String author,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "publisher", required = false) String publisher,
            @RequestParam(name = "contentType", required = false) String contentType) {
        Book criteria = Book.builder()
                .subject(subject)
                .author(author)
                .category(category)
                .publisher(publisher)
                .contentType(contentType)
                .build();
        return RestResponse.success(bookService.list());
    }



    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public RestResponse<Book> info(@PathVariable("id") Integer id) {
        return RestResponse.success(bookService.queryById(id));
    }

    /**
     * 保存
     */
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,headers = {"Accept=application/json"})
    public RestResponse<Book> add(
            @RequestParam("file")MultipartFile file,
            HttpServletRequest request,
            BookDTO book) {
        String filePath = uploadService.upload(file);
        book.setPath(filePath);
        return RestResponse.success(bookService.add(this.convert(book, Book.class)));
    }

    /**
     * 修改
     */
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/update",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,headers = {"Accept=application/json"})
    public RestResponse<Book> update(
            @RequestParam("file")MultipartFile file,
           BookDTO book) {
        String filePath = uploadService.upload(file);
        book.setPath(filePath);
        return RestResponse.success(bookService.update(this.convert(book, Book.class)));

    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
        return RestResponse.success();
    }

    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public RestResponse<Void> buy(@RequestParam("id") Integer id,
                                  @RequestParam("paymentMode") String paymentMode) {
        PaymentMode paymentModeVar = PaymentMode.getByType(paymentMode);
        BizAssert.isNotNull(paymentModeVar,"不支持的支付类型");
        bookService.buy(id,paymentMode);
        return RestResponse.success();

    }

}
