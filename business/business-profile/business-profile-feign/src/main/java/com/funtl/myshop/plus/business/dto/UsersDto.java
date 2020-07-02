package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersDto implements Serializable {
    private Long userAuto;
    private String username;
}
