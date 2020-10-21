package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "新增契约台数-车辆来源")
public class CarSourceNum implements Serializable {
    private BigDecimal eastNewNum;

    private BigDecimal eastOldNum;

    private BigDecimal southNewNum;

    private BigDecimal southOldNum;

    private BigDecimal totalNums;

    @ApiModelProperty(value = "华东-车辆来源-新车①")
    private String eastNewNumN;

    @ApiModelProperty(value = "华东-车辆来源-旧车②")
    private String eastOldNumN;

    @ApiModelProperty(value = "华南-车辆来源-新车③")
    private String southNewNumN;

    @ApiModelProperty(value = "华南-车辆来源-旧车④")
    private String southOldNumN;

    @ApiModelProperty(value = "新增契约租金(①+②+③+④)")
    private String totalNumsN;

    @ApiModelProperty(value = "新增契约租金（交车）")
    private String tableThreeName;
}
