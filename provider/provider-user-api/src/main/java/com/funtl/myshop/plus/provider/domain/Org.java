package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
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
    @Id
    @Column(name = "Org_Auto")
    private Long orgAuto;

    /**
    * 部门代码
    */
    @Column(name = "DepCode")
    private String depCode;

    /**
    * 虚部门代码
    */
    @Column(name = "SubCode")
    private String subCode;

    /**
    * 部门名称
    */
    @Column(name = "DepName")
    private String depName;

    /**
    * 等级
    */
    @Column(name = "Lev")
    private Integer lev;

    /**
    * 上级单位
    */
    @Column(name = "UpUnit")
    private Long upUnit;

    /**
    * 会计代码
    */
    @Column(name = "AccCode")
    private String accCode;

    @Column(name = "IsSalesDep")
    private Integer isSalesDep;

    private static final long serialVersionUID = 1L;
}
