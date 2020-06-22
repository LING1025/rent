package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LineChartQueryParam implements Serializable {
    private Long userAuto;
    private String startDate;
    private String endDate;
    private Long orgAuto;
    private Long orgUpAuto;

    public LineChartQueryParam(Long userAuto, String startDate, String endDate, Long orgAuto, Long orgUpAuto) {
        this.userAuto = userAuto;
        this.startDate = startDate;
        this.endDate = endDate;
        this.orgAuto = orgAuto;
        this.orgUpAuto = orgUpAuto;
    }
}
