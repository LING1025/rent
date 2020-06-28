package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MonthListDto implements Serializable {
    private List<PCountMoneys> thisMonth;
    private Long orgAuto;
    private Long salesAuto;

    private String fName;
}
