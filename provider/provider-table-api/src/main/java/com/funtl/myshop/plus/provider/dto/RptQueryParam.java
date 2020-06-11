package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RptQueryParam implements Serializable {
    private Integer year;
    private Integer month;
    private Long salesAuto;
    /*private String startDate;
    private String endDate;*/

    public RptQueryParam(Integer year, Integer month, Long salesAuto) {
        this.year = year;
        this.month = month;
        this.salesAuto = salesAuto;
    }
}
