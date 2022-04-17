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
    @GetMapping("/page")
    public RestResponse<PageVO<Contract>> queryByPage() {
        return RestResponse.success(null);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public RestResponse<Contract> info(@PathVariable("id") Integer id) {
        return RestResponse.success(null);
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public RestResponse<Contract> save(@RequestBody Contract contract) {
        return RestResponse.success(null);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public RestResponse<Contract> update(@RequestBody @Validated Contract contract) {
        return RestResponse.success(null);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public RestResponse<Void> delete(@PathVariable("id") Integer ids) {
        return RestResponse.VOID;
    }

}
