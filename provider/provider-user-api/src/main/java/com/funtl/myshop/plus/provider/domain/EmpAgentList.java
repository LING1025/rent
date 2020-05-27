package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmpAgentList implements Serializable {
    private Long empBaseAuto;

    private String fName;

    private Long orgAuto;

    private String orgName;

}
