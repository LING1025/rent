package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
    * 用户和角色的绑定
    */
@Data
@Table(name = "[aspnet_UsersInRoles]")
public class AspnetUsersInRoles implements Serializable {
    /**
    * 用户id
    */
    @Column(name = "UserId")
    private Object userId;

    /**
    * 角色id
    */
    @Column(name = "RoleId")
    private Object roleId;

    private static final long serialVersionUID = 1L;
}
