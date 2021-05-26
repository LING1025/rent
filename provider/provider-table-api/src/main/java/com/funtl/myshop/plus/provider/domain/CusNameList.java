package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "客户来源下拉选数据")
public class CusNameList implements Serializable {
    @ApiModelProperty(value = "客户来源序号")
    private Long num;

    @ApiModelProperty(value = "客户来源名称")
    private String customerName;
}
