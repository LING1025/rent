package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserListQueryParams implements Serializable {
    private String username;
    private Integer isOn;
    private Integer pageNum;
    private Integer pageSize;

    public UserListQueryParams(String username, Integer isOn, Integer pageNum, Integer pageSize) {
        this.username = username;
        this.isOn = isOn;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
