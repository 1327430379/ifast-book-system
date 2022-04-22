package com.fhk.sample.web.controller;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.Cheque;
import com.fhk.sample.service.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 支票
 *
 * @author lingzan
 * @date 2022-04-16 09:52:44
 */
@RestController
@RequestMapping("cheque")
public class ChequeController extends BaseController {
    @Autowired
    private ChequeService chequeService;

    /**
     * 列表
     */
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResponse<List<Cheque>> list() {
        return RestResponse.success(chequeService.list());
    }


    /**
     * 审核
     */
    @PreAuthorize("hasAuthority('moderator')")
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public RestResponse<Void> approve(@RequestParam("id") Integer id) {
        chequeService.approve(id);
        return RestResponse.success();
    }


}
