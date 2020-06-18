package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RptQueryParams implements Serializable {
    private Integer year;
    private Integer month;
    private String startDate;
    private String endDate;
    private Long orgAuto;

    public RptQueryParams(Integer year, Integer month, String startDate, String endDate, Long orgAuto) {
        this.year = year;
        this.month = month;
        this.startDate = startDate;
        this.endDate = endDate;
        this.orgAuto = orgAuto;
    }
}
