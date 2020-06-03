package com.funtl.myshop.plus.business.dto.params;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConsumerParam implements Serializable {
    private Long userAuto;
    private String mobilePIN;
    private String email;
    private String username;
    /**
     * 启用状态0停用 1启用 2删除
     */
    private Integer isOn;
}
