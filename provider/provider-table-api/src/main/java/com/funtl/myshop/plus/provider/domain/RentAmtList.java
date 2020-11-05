package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "新增契约租金-客户来源")
public class RentAmtList implements Serializable {
    @ApiModelProperty(value = "标题名")
    private String titleName;

    @ApiModelProperty(value = "当月目标")
    private BigDecimal thisMonTar=BigDecimal.valueOf(0);

    @ApiModelProperty(value = "当月实绩")
    private BigDecimal thisMonAct=BigDecimal.valueOf(0);

    @ApiModelProperty(value = "结构比")
    private String structure;

    @ApiModelProperty(value = "达成率")
    private String reach;

    @ApiModelProperty(value = "上月实绩")
    private BigDecimal lastMonAct=BigDecimal.valueOf(0);

    @ApiModelProperty(value = "环比")
    private String link;

    @ApiModelProperty(value = "去年实绩")
    private BigDecimal lastYearAct=BigDecimal.valueOf(0);

    @ApiModelProperty(value = "结构比")
    private String construction;

    @ApiModelProperty(value = "同期对比")
    private String comparison;
}
