package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    * 部门员工关系表
    */
@Data
@Table(name = "[Org2Emp]")
public class Org2Emp implements Serializable {
    /**
    * 部门员工关系表id
    */
    @Id
    @Column(name = "Org2Emp_Auto")
    private Long org2EmpAuto;

    /**
    * 用户表id
    */
    @Column(name = "User_Auto")
    private Long userAuto;

    /**
    * 部门表id
    */
    @Column(name = "Org_Auto")
    private Long orgAuto;

    @Column(name = "ACLType")
    private Integer ACLType;

    private static final long serialVersionUID = 1L;
}
