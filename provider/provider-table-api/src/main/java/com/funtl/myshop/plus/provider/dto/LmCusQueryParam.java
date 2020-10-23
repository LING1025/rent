package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "上个月保有客户台数查询参数")
public class LmCusQueryParam implements Serializable {
    private Integer type;
    private Integer yy;
    private Integer mm;
    private Integer orderType;
    private Integer incAuto;
    private Integer pageSize;
    private Integer page;

    public LmCusQueryParam(Integer type, Integer yy, Integer mm, Integer orderType, Integer incAuto, Integer pageSize, Integer page) {
        this.type = type;
        this.yy = yy;
        this.mm = mm;
        this.orderType = orderType;
        this.incAuto = incAuto;
        this.pageSize = pageSize;
        this.page = page;
    }
}
