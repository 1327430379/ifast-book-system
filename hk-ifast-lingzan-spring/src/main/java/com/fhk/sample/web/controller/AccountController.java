package com.fhk.sample.web.controller;


import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Account;
import com.fhk.sample.service.AccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


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
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RestResponse<List<Account>> list(){
        return RestResponse.success(accountService.list());
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public RestResponse<Account> info(@PathVariable("id") Integer id){
        return RestResponse.success(accountService.queryById(id));
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/username",method = RequestMethod.GET)
    public RestResponse<Account> queryByUsername(@RequestParam("username") String username){
        return RestResponse.success(accountService.queryByUsername(username));
    }



}
