package com.fhk.sample.web.controller;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.dto.PublisherDTO;
import com.fhk.sample.domain.entity.Publisher;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.PublisherService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 出版社
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("publisher")
public class PublisherController extends BaseController {

    @Resource
    private PublisherService publisherService;

    /**
     * 分页列表
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public RestResponse<PageVO<Publisher>> queryByPage(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                       @RequestParam(name = "pageSize", defaultValue = "20", required = false) Integer pageSize) {
        return RestResponse.success(publisherService.queryByPage(pageNum, pageSize, null));
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RestResponse<List<Publisher>> listAll() {
        return RestResponse.success(publisherService.listAll());
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public RestResponse<Publisher> info(@PathVariable("id") Integer id) {
        return RestResponse.success(publisherService.queryById(id));
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RestResponse<Publisher> add(@RequestBody @Validated(value = PublisherDTO.InsertGroup.class) PublisherDTO publisher) {
        return RestResponse.success(publisherService.add(this.convert(publisher, Publisher.class)));
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResponse<Publisher> update(@RequestBody @Validated(value = PublisherDTO.UpdateGroup.class) PublisherDTO publisher) {
        return RestResponse.success(publisherService.update(this.convert(publisher, Publisher.class)));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public RestResponse<Void> delete(@PathVariable("id") Integer id) {
        publisherService.deleteById(id);
        return RestResponse.success();
    }

}
