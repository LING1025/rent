package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "客户,车辆来源当月实绩查询参数")
public class MonGoalQueryParam implements Serializable {
    private Integer inc;
    private Integer type;
    private String year;
    private String month;
    private Integer flag;
    private String customer;
    private String startDate;
    private String endDate;

    public MonGoalQueryParam(Integer inc, Integer type, String year, String month, Integer flag, String customer, String startDate, String endDate) {
        this.inc = inc;
        this.type = type;
        this.year = year;
        this.month = month;
        this.flag = flag;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
