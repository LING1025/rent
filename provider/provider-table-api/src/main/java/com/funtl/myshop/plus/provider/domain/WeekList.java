package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "周期下拉选数据")
public class WeekList implements Serializable {
    @ApiModelProperty(value = "周期")
    private String weekNo;
}
