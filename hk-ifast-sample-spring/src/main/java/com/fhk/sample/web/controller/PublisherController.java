package com.fhk.sample.web.controller;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Publisher;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.PublisherService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 出版社
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("publisher")
public class PublisherController extends BaseController{

    @Resource
    private PublisherService publisherService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    public RestResponse<PageVO<Publisher>> queryByPage(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                       @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize) {
        return RestResponse.success(publisherService.queryByPage(pageNum, pageSize, null));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public RestResponse<Publisher> info(@PathVariable("id") Integer id) {
        return RestResponse.success(publisherService.queryById(id));
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public RestResponse<Publisher> add(@RequestBody @Validated Publisher publisher) {
        return RestResponse.success(publisherService.add(publisher));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public RestResponse<Publisher> update(@RequestBody Publisher publisher) {
        return RestResponse.success(publisherService.update(publisher));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        publisherService.deleteById(id);
        return RestResponse.success();
    }

}
