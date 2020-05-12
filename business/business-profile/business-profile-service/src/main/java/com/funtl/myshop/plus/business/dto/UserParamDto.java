package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserParamDto implements Serializable {
    private Integer userId;

    private Integer sex;

    private Integer age;

    private String phone;

    private BigDecimal balance;

    private Integer isAdmin;

    private String faceUrl;

    private Byte status;
}
