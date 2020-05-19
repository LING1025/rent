package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[OrgGroup]")
public class OrgGroup implements Serializable {
    /**
    * 组id
    */
    @Id
    @Column(name = "OrgGroup_Auto")
    private Long orgGroupAuto;

    /**
    * 组名称
    */
    @Column(name = "OrgGroupName")
    private String orgGroupName;

    /**
    * 公司别
    */
    @Column(name = "Inc_Auto")
    private Integer incAuto;

    @Column(name = "District")
    private Integer district;

    @Column(name = "DepType")
    private Integer depType;

    private static final long serialVersionUID = 1L;
}
