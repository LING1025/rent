package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Table;

/**
    * 员工信息表
    */
@Data
@Table(name = "[EmpBase]")
public class EmpBase implements Serializable {
    /**
    * 员工id
    */
    private Long empBaseAuto;

    /**
    * 对象id
    */
    private Long tradeItemAuto;

    /**
    * 部门id
    */
    private Long orgAuto;

    /**
    * 部门名称
    */
    private String orgName;

    /**
    * 职位表id
    */
    private Integer incTitleAuto;

    /**
    * 职位
    */
    private String title;

    /**
    * 员工姓名
    */
    private String fName;

    /**
    * 用户名
    */
    private String username;

    /**
    * 启用状态
    */
    private Integer isOn;

    private String extension;

    /**
    * 是否为主管
    */
    private Integer isBoss;

    private Date mDT;

    private Integer mUser;

    private static final long serialVersionUID = 1L;
}
