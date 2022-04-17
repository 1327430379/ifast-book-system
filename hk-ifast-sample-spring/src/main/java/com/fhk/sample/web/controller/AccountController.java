package com.fhk.sample.web.controller;


import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Account;
import com.fhk.sample.domain.vo.PageVO;
import com.fhk.sample.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;




/**
 * 
 *
 * @author lingzan
 * 
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("account")
public class AccountController extends BaseController{
    @Resource
    private AccountService accountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public RestResponse<PageVO<Account>> list(@RequestParam Map<String, Object> params){
        return RestResponse.success(null);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public RestResponse<Account> info(@PathVariable("id") Integer id){
        return RestResponse.success(null);
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public RestResponse<Account> save(@RequestBody Account account){
        return RestResponse.success(null);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public RestResponse<Account> update(@RequestBody Account account){
        return RestResponse.success(null);
    }


}
