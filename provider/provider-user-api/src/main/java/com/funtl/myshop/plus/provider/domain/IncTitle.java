package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    * 职位表
    */
@Data
@Table(name = "[IncTitle]")
public class IncTitle implements Serializable {
    /**
    * 职位id
    */
    @Id
    @Column(name = "IncTitle_Auto")
    private Integer incTitleAuto;

    @Column(name = "Inc_Auto")
    private Integer incAuto;

    /**
    * 职位名
    */
    @Column(name = "TitleName")
    private String titleName;

    /**
    * 职位等级
    */
    @Column(name = "TitleLevel")
    private Integer titleLevel;

    private static final long serialVersionUID = 1L;
}
