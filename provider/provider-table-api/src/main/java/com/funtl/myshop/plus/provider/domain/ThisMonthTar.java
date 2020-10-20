package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "当月目标")
public class ThisMonthTar implements Serializable {
    @ApiModelProperty(value = "客户来源-新拓①")
    private BigDecimal newExs;

    @ApiModelProperty(value = "客户来源-保有②")
    private BigDecimal retain;

    @ApiModelProperty(value = "客户来源-介绍③")
    private BigDecimal introduce;

    @ApiModelProperty(value = "新增契约租金(①+②+③)")
    private BigDecimal totalNumAmt;

    @ApiModelProperty(value = "新增契约租金（交车）")
    private String tableName;

}
