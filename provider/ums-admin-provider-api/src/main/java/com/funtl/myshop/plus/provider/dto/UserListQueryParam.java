package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserListQueryParam implements Serializable {
    private String username;

    private String phone;

    private Byte status;

    public UserListQueryParam(String username, String phone, Byte status) {
        this.username = username;
        this.phone = phone;
        this.status = status;
    }
}
