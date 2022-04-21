package com.fhk.sample.web.controller;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.entity.TransRecord;
import com.fhk.sample.service.TransRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/trans/record")
public class TransRecordController {


    @Resource
    private TransRecordService transRecordService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResponse<List<TransRecord>> list(@RequestParam("accountId") Integer accountId) {
        return RestResponse.success(transRecordService.queryByAccountId(accountId));
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public RestResponse<List<TransRecord>> queryById(@PathVariable("id") Integer id) {
        return RestResponse.success(transRecordService.queryByAccountId(id));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public RestResponse<TransRecord> add(@RequestBody TransRecord transRecord) {
        return RestResponse.success(transRecordService.add(transRecord));
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public RestResponse<Void> delete(@RequestParam("id") Integer id) {
        transRecordService.deleteById(id);
        return RestResponse.VOID;
    }

}