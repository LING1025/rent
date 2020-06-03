package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserList implements Serializable {
    private Long userAuto;
    private String mobilePIN;
    private String email;
    private String fName;
    private String username;

    /**
     * 启用状态0停用 1启用 2删除
     */
    private Integer isOn;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date mDT;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date cDT;
}
