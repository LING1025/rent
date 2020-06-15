package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LineChartQueryParam implements Serializable {
    private Long userAuto;
    private String username;
    private Integer year;
    private Integer month;

}
