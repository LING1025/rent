package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReqFormQueryParam implements Serializable {
    private Integer type;
    private String orgName;
    private Integer status;
    private Long userAuto;
    private Integer pageNum;
    private Integer pageSize;

    public ReqFormQueryParam(Integer type, String orgName, Integer status, Long userAuto, Integer pageNum, Integer pageSize) {
        this.type = type;
        this.orgName = orgName;
        this.status = status;
        this.userAuto = userAuto;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
