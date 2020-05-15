package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "[aspnet_Roles]")
public class AspnetRoles implements Serializable {
    private Object roleId;

    private Object applicationId;

    /**
    * 角色名
    */
    private String roleName;

    /**
    * 小写角色名
    */
    private String loweredRoleName;

    /**
    * 描述
    */
    private String description;

    /**
    * 角色id
    */
    private Long rolesAuto;

    /**
    * 等级
    */
    private Integer titleLevel;

    private Integer orgAuto;

    private static final long serialVersionUID = 1L;
}
