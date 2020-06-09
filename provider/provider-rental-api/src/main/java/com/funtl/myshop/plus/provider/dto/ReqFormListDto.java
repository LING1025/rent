package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReqFormListDto implements Serializable {
    private Long userAuto;
    private Integer type;
    private Integer mode;
    private Date expectDT;
    private String contents;
    private Integer status;
    private String flowList;
    private Integer reason;
    private Integer degree;
    private String subject;
    private String fileName;
    private Date cDT;

    // 两个分类相加 type+mode
    private Integer typeMode;
    private String orgName;
}
