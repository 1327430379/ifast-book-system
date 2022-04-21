package com.fhk.sample.web.controller;


import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Contract;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.ContractService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 合同表
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("/contract")
public class ContractController {
    @Resource
    private ContractService contractService;

    /**
     * 列表
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public RestResponse<PageVO<Contract>> queryByPage() {
        return RestResponse.success(null);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public RestResponse<Contract> info(@PathVariable("id") Integer id) {
        return RestResponse.success(null);
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RestResponse<Contract> save(@RequestBody Contract contract) {
        return RestResponse.success(null);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResponse<Contract> update(@RequestBody @Validated Contract contract) {
        return RestResponse.success(null);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public RestResponse<Void> delete(@PathVariable("id") Integer ids) {
        return RestResponse.VOID;
    }


    @RequestMapping(value = "/void",method = RequestMethod.POST)
    public RestResponse<Void> voiding(@RequestParam("id")Integer id){
        contractService.voiding(id);
        return RestResponse.success();
    }
}
