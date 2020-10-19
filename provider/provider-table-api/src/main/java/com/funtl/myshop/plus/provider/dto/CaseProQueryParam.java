package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "案件进度维护查询参数")
public class CaseProQueryParam implements Serializable {
    private Integer inc;
    private Integer type;
    private Integer year;
    private Integer month;
    private Integer flag;
    private String customer;
    /*private Integer pageNum;
    private Integer pageSize;*/

    public CaseProQueryParam(Integer inc, Integer type, Integer year, Integer month, Integer flag, String customer) {
        this.inc = inc;
        this.type = type;
        this.year = year;
        this.month = month;
        this.flag = flag;
        this.customer = customer;
    }
}
