package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgentList implements Serializable {
    private Long userAuto;

    private String fName;

    private Long orgAuto;

    private String depName;
}
