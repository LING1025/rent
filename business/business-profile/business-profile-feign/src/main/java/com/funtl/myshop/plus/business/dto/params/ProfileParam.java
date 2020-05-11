package com.funtl.myshop.plus.business.dto.params;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProfileParam implements Serializable {
    private Integer userId;

    private String username;

    private Integer sex;

    private Integer age;

    private String phone;

    private Object balance;

    private Integer isAdmin;

    private String faceUrl;
}
