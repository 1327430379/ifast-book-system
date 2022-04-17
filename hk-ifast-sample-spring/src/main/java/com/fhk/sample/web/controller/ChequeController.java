package com.fhk.sample.web.controller;

import java.util.Arrays;
import java.util.Map;

import com.fhk.sample.common.rest.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhk.sample.domain.entity.Cheque;
import com.fhk.sample.service.ChequeService;


/**
 * 支票
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("generator/cheque")
public class ChequeController extends BaseController{
    @Autowired
    private ChequeService chequeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public RestResponse<Void> list(@RequestParam Map<String, Object> params) {
        return RestResponse.success();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public RestResponse<Void> info(@PathVariable("id") Integer id) {
        return RestResponse.success();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public RestResponse<Void> save(@RequestBody Cheque cheque) {
        return RestResponse.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public RestResponse<Void> update(@RequestBody Cheque cheque) {
        return RestResponse.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public RestResponse<Void> delete(@RequestBody Integer[] ids) {
        return RestResponse.VOID;
    }

}
