package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "年度新增呆账&回收数据")
public class YearList implements Serializable {
    @ApiModelProperty(value = "周期")
    private String weekNo;

    @ApiModelProperty(value = "新增呆账(件数)")
    private Integer ruDaiCount;

    @ApiModelProperty(value = "新增呆账(金额)")
    private BigDecimal ruDaiAmt;

    @ApiModelProperty(value = "呆账回收(金额)")
    private BigDecimal backAmt;

}
