package com.fhk.sample.web.controller;

import com.fhk.sample.common.constants.SupportFileType;
import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.entity.Shelf;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.BookService;
import com.fhk.sample.service.FileReader;
import com.fhk.sample.service.ShelfService;
import com.fhk.sample.service.impl.PDFReader;
import com.fhk.sample.service.impl.TXTReader;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 用户书架
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("shelf")
public class ShelfController extends BaseController {
    @Resource
    private ShelfService shelfService;
    @Resource
    private BookService bookService;


    /**
     * 分页列表
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public RestResponse<PageVO<Shelf>> queryByPage() {
        return RestResponse.success(null);
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResponse<List<Shelf>> list() {
        return RestResponse.success(shelfService.list());
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public RestResponse<Shelf> info(@PathVariable("id") Integer id) {
        return RestResponse.success(shelfService.queryById(id));
    }


    /**
     * 删除
     */
    @RequestMapping(value = "/delete/id", method = RequestMethod.DELETE)
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        return RestResponse.success();
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public void read(@RequestParam("id") Integer id, HttpServletResponse response) throws Exception {
        Shelf shelf = shelfService.saveReadRecord(id);
        Book book = shelf.getBook();
        FileReader fileReader = null;
        if (SupportFileType.PDF.equals(book.getContentType())) {
            fileReader = new PDFReader();
        } else if (SupportFileType.TXT.equals(book.getContentType())) {
            fileReader = new TXTReader();
        }
        fileReader.read(book.getPath(),response);
    }


}
