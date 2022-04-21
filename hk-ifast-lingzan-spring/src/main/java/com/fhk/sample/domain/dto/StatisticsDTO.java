package com.fhk.sample.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StatisticsDTO {

    private BigDecimal totalCash;

    private Integer totalCompletedContract;

    private Integer totalVoidedContract;
}
