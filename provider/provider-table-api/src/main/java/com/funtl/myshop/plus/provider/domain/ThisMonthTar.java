package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "新增契约租金-客户来源")
public class ThisMonthTar implements Serializable {
    @JsonIgnore
    private BigDecimal newExs=BigDecimal.valueOf(0);

    @JsonIgnore
    private BigDecimal retain=BigDecimal.valueOf(0);

    @JsonIgnore
    private BigDecimal introduce=BigDecimal.valueOf(0);

    @JsonIgnore
    private BigDecimal totalNumAmt=BigDecimal.valueOf(0);

    @ApiModelProperty(value = "客户来源-新拓①")
    private String newExsNew;

    @ApiModelProperty(value = "客户来源-保有②")
    private String retainNew;

    @ApiModelProperty(value = "客户来源-介绍③")
    private String introduceNew;

    @ApiModelProperty(value = "新增契约租金(①+②+③)")
    private String totalNew;

    @ApiModelProperty(value = "新增契约租金（交车）")
    private String tableName;

}
