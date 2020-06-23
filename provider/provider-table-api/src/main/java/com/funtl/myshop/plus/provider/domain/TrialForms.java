package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "试算营业报表数据")
public class TrialForms implements Serializable {

    @ApiModelProperty(value = "年月")
    private Integer mm;

    @ApiModelProperty(value = "日")
    private Integer dd;

    @ApiModelProperty(value = "台数")
    private Integer pCount;

    @ApiModelProperty(value = "金额")
    private Integer pMoney;

    private Long orgAuto;
    private Long salesAuto;

    private String fName;
}
