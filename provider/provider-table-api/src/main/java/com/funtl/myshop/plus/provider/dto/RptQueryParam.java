package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RptQueryParam implements Serializable {
    private Integer year;
    private Integer month;
    private String startDate;
    private String endDate;
    private List<Long> orgAutos;

    public RptQueryParam(Integer year, Integer month, String startDate, String endDate, List<Long> orgAutos) {
        this.year = year;
        this.month = month;
        this.startDate = startDate;
        this.endDate = endDate;
        this.orgAutos = orgAutos;
    }
}
