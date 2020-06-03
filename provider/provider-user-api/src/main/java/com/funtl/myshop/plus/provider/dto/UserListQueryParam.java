package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserListQueryParam implements Serializable {
    private String username;
    private Integer isOn;
    private Integer pageNum;
    private Integer pageSize;

    public UserListQueryParam(String username, Integer isOn, Integer pageNum, Integer pageSize) {
        this.username = username;
        this.isOn = isOn;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
