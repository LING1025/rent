package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "[OrgGroup]")
public class OrgGroup implements Serializable {
    /**
    * 组id
    */
    private Long orgGroupAuto;

    /**
    * 组名称
    */
    private String orgGroupName;

    /**
    * 公司别
    */
    private Integer incAuto;

    private Integer district;

    private Integer depType;

    private static final long serialVersionUID = 1L;
}
