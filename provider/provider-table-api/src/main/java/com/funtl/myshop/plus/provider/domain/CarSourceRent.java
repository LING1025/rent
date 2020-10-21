package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "新增契约租金-车辆来源")
public class CarSourceRent implements Serializable {
    private BigDecimal eastNewCar;

    private BigDecimal eastOldCar;

    private BigDecimal southNewCar;

    private BigDecimal southOldCar;

    private BigDecimal totalNumAmt;

    @ApiModelProperty(value = "华东-车辆来源-新车①")
    private String eastNewCarN;

    @ApiModelProperty(value = "华东-车辆来源-旧车②")
    private String eastOldCarN;

    @ApiModelProperty(value = "华南-车辆来源-新车③")
    private String southNewCarN;

    @ApiModelProperty(value = "华南-车辆来源-旧车①")
    private String southOldCarN;

    @ApiModelProperty(value = "新增契约租金(①+②+③)")
    private String totalNumAmtN;

    @ApiModelProperty(value = "新增契约租金（交车）")
    private String tableTwoName;
}
