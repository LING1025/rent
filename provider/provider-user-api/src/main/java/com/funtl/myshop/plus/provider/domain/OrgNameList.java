package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class OrgNameList implements Serializable {
    /**
     * 部门表id
     */
    private Long orgAuto;

    /**
     * 部门名称
     */
    private String depName;
}
