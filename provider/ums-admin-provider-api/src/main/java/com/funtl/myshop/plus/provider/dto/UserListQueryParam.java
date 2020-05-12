package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserListQueryParam implements Serializable {
    private String username;

    private Integer isAdmin;

    private Byte status;

    public UserListQueryParam(String username, Integer isAdmin, Byte status) {
        this.username = username;
        this.isAdmin = isAdmin;
        this.status = status;
    }
}
