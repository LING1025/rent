package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RptQueryParams implements Serializable {
    private Integer Type;
    private Long UserID;
    private String StartDT_F;
    private String StartDT_E;

    public RptQueryParams(Integer type, Long userID, String startDT_F, String startDT_E) {
        Type = type;
        UserID = userID;
        StartDT_F = startDT_F;
        StartDT_E = startDT_E;
    }
}
