package com.fhk.sample.web.controller;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.dao.ShelfRepository;
import com.fhk.sample.domain.entity.Shelf;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.ShelfService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;


/**
 * 用户书架
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
public class ShelfController extends BaseController {
    @Resource
    private ShelfService shelfService;

    /**
     * 列表
     */
    @GetMapping("/page")
    public RestResponse<PageVO<Shelf>> queryByPage() {
        return RestResponse.success(null);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public RestResponse<Shelf> info(@PathVariable("id") Integer id) {
        return RestResponse.success(null);
    }

    /**
     * 购买书籍
     */
    @RequestMapping("/buy")
    public RestResponse<Void> buy(@RequestParam("id") Integer id,
                                  @RequestParam("paymentMode") String paymentMode) {
        return RestResponse.success();
    }

    /**
     * 阅读书籍
     *
     * @param shelfId
     * @return
     */
    @GetMapping("/read")
    public RestResponse<Void> readBooks(@RequestParam("shelfId") Integer shelfId) {
        return RestResponse.success();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete/id")
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        return RestResponse.success();
    }

}
