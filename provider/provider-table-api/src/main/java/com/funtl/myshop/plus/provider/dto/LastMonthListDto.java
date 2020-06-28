package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LastMonthListDto implements Serializable {
    private List<PCountMoneyLast> lastMonth;
    private Long orgAuto;
    private Long salesAuto;

    private String fName;
}
