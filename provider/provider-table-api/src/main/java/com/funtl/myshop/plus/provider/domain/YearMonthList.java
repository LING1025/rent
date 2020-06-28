package com.funtl.myshop.plus.provider.domain;

import com.funtl.myshop.plus.provider.dto.PCountMoneyLast;
import com.funtl.myshop.plus.provider.dto.PCountMoneys;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class YearMonthList implements Serializable {
    @ApiModelProperty(value = "年月")
    private String yearMon;

    @ApiModelProperty(value = "日")
    private String days;

    @ApiModelProperty(value = "台数")
    private Integer pCount;

    @ApiModelProperty(value = "金额")
    private Integer pMoney;

    @ApiModelProperty(value = "年月")
    private String yearMonLast;

    @ApiModelProperty(value = "日")
    private String daysLast;

    @ApiModelProperty(value = "台数")
    private Integer pCountLast;

    @ApiModelProperty(value = "金额")
    private Integer pMoneyLast;
    private Long orgAuto;
    private Long salesAuto;

    private String fName;
}
