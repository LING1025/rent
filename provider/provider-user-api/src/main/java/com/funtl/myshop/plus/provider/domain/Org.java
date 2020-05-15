package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Table;

/**
    * 部门表
    */
@Data
@Table(name = "[Org]")
public class Org implements Serializable {
    /**
    * 部门表id
    */
    private Long orgAuto;

    /**
    * 部门代码
    */
    private String depCode;

    /**
    * 虚部门代码
    */
    private String subCode;

    /**
    * 部门名称
    */
    private String depName;

    /**
    * 等级
    */
    private Integer lev;

    /**
    * 上级单位
    */
    private Long upUnit;

    /**
    * 会计代码
    */
    private String accCode;

    private Integer isSalesDep;

    private static final long serialVersionUID = 1L;
}
