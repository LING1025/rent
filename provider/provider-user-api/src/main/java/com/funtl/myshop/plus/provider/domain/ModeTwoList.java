package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ModeTwoList implements Serializable {
    private Long orgAuto;
    private String depName;
    private Long userAuto;
}
