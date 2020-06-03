package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UsersParamDto implements Serializable {
    private Long userAuto;
    private String mobilePIN;
    private String email;
//    private String username;

    /**
     * 启用状态0停用 1启用 2删除
     */
    private Integer isOn;
}
