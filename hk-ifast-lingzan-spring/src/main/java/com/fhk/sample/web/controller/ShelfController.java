package com.fhk.sample.web.controller;

import com.fhk.sample.common.constants.SupportFileType;
import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Book;
import com.fhk.sample.domain.entity.Shelf;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.BookService;
import com.fhk.sample.service.DownloadService;
import com.fhk.sample.service.FileReader;
import com.fhk.sample.service.ShelfService;
import com.fhk.sample.service.impl.PDFReader;
import com.fhk.sample.service.impl.TXTReader;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping("shelf")
public class ShelfController extends BaseController {
    @Resource
    private ShelfService shelfService;
    @Resource
    private BookService bookService;
    @Resource
    private DownloadService downloadService;


    /**
     * 分页列表
     */
    @PreAuthorize("hasAuthority('customer')")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<PageVO<Shelf>> queryByPage() {
        return RestResponse.success(null);
    }

    /**
     * 列表
     */
    @PreAuthorize("hasAuthority('customer')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<List<Shelf>> list() {
        return RestResponse.success(shelfService.list());
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<Shelf> info(@PathVariable("id") Integer id) {
        return RestResponse.success(shelfService.queryById(id));
    }


    /**
     * 删除
     */
    @PreAuthorize("hasAuthority('customer')")
    @RequestMapping(value = "/delete/id", method = RequestMethod.DELETE)
    @ResponseBody
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        return RestResponse.success();
    }


    @RequestMapping(value = "/read", method = RequestMethod.POST)
//    @ResponseBody
    public ResponseEntity<byte[]> read(@RequestParam("id") Integer id, HttpServletResponse response) throws Exception {
        Shelf shelf = shelfService.saveReadRecord(id);
        Book book = shelf.getBook();
        return downloadService.download(book.getPath(),response);
    }


}
