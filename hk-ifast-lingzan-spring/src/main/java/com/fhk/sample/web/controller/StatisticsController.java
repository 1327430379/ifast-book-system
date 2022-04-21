package com.fhk.sample.web.controller;

import com.fhk.sample.common.rest.RestResponse;
import com.fhk.sample.domain.dto.StatisticsDTO;
import com.fhk.sample.service.StatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {



    @Resource
    private StatisticsService statisticsService;

    @RequestMapping("/show")
    public RestResponse<StatisticsDTO> show() {
        return RestResponse.success(statisticsService.show());
    }

}
