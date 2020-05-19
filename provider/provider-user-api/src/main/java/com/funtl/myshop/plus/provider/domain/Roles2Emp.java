package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    * 员工角色关系表
    */
@Data
@Table(name = "[Roles2Emp]")
public class Roles2Emp implements Serializable {
    /**
    * 员工角色关系表id
    */
    @Id
    @Column(name = "Roles2Emp_Auto")
    private Long roles2EmpAuto;

    /**
    * 员工id
    */
    @Column(name = "EmpBase_Auto")
    private Long empBaseAuto;

    /**
    * 角色id
    */
    @Column(name = "Roles_Auto")
    private Long roles_Auto;

    private static final long serialVersionUID = 1L;
}
