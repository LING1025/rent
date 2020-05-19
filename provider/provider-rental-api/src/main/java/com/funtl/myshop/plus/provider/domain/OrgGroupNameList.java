package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class OrgGroupNameList implements Serializable {
    /**
     * 组id
     */
    private Long orgGroupAuto;
    /**
     * 组名称
     */
    private String orgGroupName;
}
