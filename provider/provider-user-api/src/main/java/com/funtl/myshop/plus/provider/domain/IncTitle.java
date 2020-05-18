package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

/**
    * 职位表
    */
@Data
public class IncTitle implements Serializable {
    /**
    * 职位id
    */
    private Integer incTitleAuto;

    private Integer incAuto;

    /**
    * 职位名
    */
    private String titleName;

    /**
    * 职位等级
    */
    private Integer titleLevel;

    private static final long serialVersionUID = 1L;
}