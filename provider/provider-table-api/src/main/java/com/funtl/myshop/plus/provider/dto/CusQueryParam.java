package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "保有客户台数查询参数")
public class CusQueryParam implements Serializable {
    private Integer type;
    private Integer yy;
    private Integer mm;
    private Integer orderType;
    private Integer incAuto;
    private Integer pageSize;
    private Integer page;
    private String startDate;
    private String endDate;

    public CusQueryParam(Integer type, Integer yy, Integer mm, Integer orderType, Integer incAuto, Integer pageSize, Integer page, String startDate, String endDate) {
        this.type = type;
        this.yy = yy;
        this.mm = mm;
        this.orderType = orderType;
        this.incAuto = incAuto;
        this.pageSize = pageSize;
        this.page = page;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
