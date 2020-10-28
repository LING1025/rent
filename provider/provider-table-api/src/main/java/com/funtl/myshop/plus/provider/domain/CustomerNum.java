package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "保有客户台数")
public class CustomerNum implements Serializable {
    @JsonIgnore
    private Integer lmCusNum=0;

    @JsonIgnore
    private Integer createNum=0;

    @JsonIgnore
    private Integer endNum=0;

    @JsonIgnore
    private Integer beforeEndNum=0;

    @JsonIgnore
    private Integer tmCusNum=0;

    @ApiModelProperty(value = "前月保有客户台数")
    private String lmCusNumN;

    @ApiModelProperty(value = "新增业绩台数")
    private String createNumN;

    @ApiModelProperty(value = "结清-期满解约")
    private String endNumN;

    @ApiModelProperty(value = "结清-提前解约")
    private String beforeEndNumN;

    @ApiModelProperty(value = "本月保有客户台数")
    private String tmCusNumN;

    @ApiModelProperty(value = "保有客户台数（展期）")
    private String tableName;

}
