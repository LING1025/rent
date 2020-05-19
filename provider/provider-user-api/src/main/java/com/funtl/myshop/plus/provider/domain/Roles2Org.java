package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    * 部门角色关系表
    */
@Data
@Table(name = "[Roles2Org]")
public class Roles2Org implements Serializable {
    /**
    * 部门角色关系表id
    */
    @Id
    @Column(name = "Roles2Org_Auto")
    private Long roles2OrgAuto;

    /**
    * 部门id
    */
    @Column(name = "Org_Auto")
    private Long orgAuto;

    /**
    * 角色id
    */
    @Column(name = "Roles_Auto")
    private Long roles_Auto;

    private static final long serialVersionUID = 1L;
}
