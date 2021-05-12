package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "专案名称下拉选数据")
public class ProNameList implements Serializable {
    @ApiModelProperty(value = "专案序号")
    private Long projectAuto;

    @ApiModelProperty(value = "专案名称")
    private String projectName;
}
