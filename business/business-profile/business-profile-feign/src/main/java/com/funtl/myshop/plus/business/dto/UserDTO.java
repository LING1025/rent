package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String userId;

    private String username;

    private Integer sex;

    private Integer age;

    private String phone;

    private Object balance;

    private Integer isAdmin;

    private String faceUrl;
}
