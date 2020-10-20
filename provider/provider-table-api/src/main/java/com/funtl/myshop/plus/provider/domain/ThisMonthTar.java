package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "新增契约租金-客户来源")
public class ThisMonthTar implements Serializable {
    @ApiModelProperty(value = "客户来源-新拓①")
    private BigDecimal newExs;

    @ApiModelProperty(value = "客户来源-保有②")
    private BigDecimal retain;

    @ApiModelProperty(value = "客户来源-介绍③")
    private BigDecimal introduce;

    @ApiModelProperty(value = "新增契约租金(①+②+③)")
    private BigDecimal totalNumAmt;

    @ApiModelProperty(value = "最终%计算客户来源-新拓①")
    private String newExsNew;

    @ApiModelProperty(value = "最终%计算客户来源-保有②")
    private String retainNew;

    @ApiModelProperty(value = "最终%计算客户来源-介绍③")
    private String introduceNew;

    @ApiModelProperty(value = "最终%计算新增契约租金(①+②+③)")
    private String totalNew;

    @ApiModelProperty(value = "新增契约租金（交车）")
    private String tableName;

}
