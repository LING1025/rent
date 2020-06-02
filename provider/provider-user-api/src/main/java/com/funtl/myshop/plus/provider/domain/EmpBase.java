package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
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
    @Id
    @Column(name = "EmpBase_Auto")
    private Long empBaseAuto;

    /**
    * 对象id
    */
    @Column(name = "TradeItem_Auto")
    private Long tradeItemAuto;

    /**
    * 部门id
    */
    @Column(name = "Org_Auto")
    private Long orgAuto;

    /**
    * 部门名称
    */
    @Column(name = "OrgName")
    private String orgName;

    /**
    * 职位表id
    */
    @Column(name = "IncTitle_Auto")
    private Integer incTitleAuto;

    /**
    * 职位
    */
    @Column(name = "Title")
    private String title;

    /**
    * 员工姓名
    */
    @Column(name = "FName")
    private String fName;

    /**
    * 用户名
    */
    @Column(name = "UserName")
    private String username;

    /**
    * 启用状态
    */
    @Column(name = "IsOn")
    private Integer isOn;

    @Column(name = "Extension")
    private String extension;

    /**
    * 是否为主管
    */
    @Column(name = "IsBoss")
    private Integer isBoss;

    /**
     * 修改日期
     */
    @Column(name = "MDT")
    private Date mDT;

    @Column(name = "MUser")
    private Integer mUser;

    /**
     * 组id
     */
    @Column(name = "OrgGroup_Auto")
    private Long orgGroupAuto;

    /**
     * 组名称
     */
    @Column(name = "OrgGroupName")
    private String orgGroupName;

    /**
     * 创建日期
     */
    @Column(name = "CDT")
    private Date cDT;

    /**
     * 角色id
     */
    /*@Column(name = "Roles_Auto")
    private Long rolesAuto;*/

    /**
     * 角色名
     */
    /*@Column(name = "RoleName")
    private String roleName;*/

    private static final long serialVersionUID = 1L;
}
