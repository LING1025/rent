package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[ItemCode]")
public class ItemCode implements Serializable {
    /**
    * 流水号
    */
    @Id
    @Column(name = "ItemCode_Auto")
    private Long itemCodeAuto;

    /**
    * 代码
    */
    @Column(name = "ItemType")
    private Integer itemType;

    /**
    * 项目编号（金额）
    */
    @Column(name = "Num")
    private Long num;

    /**
    * 项目內容
    */
    @Column(name = "ItemName")
    private String itemName;

    /**
    * 备注
    */
    @Column(name = "Memo")
    private String memo;

    /**
    * 是否有效 ::1有效 0停用
    */
    @Column(name = "IsActive")
    private Integer isActive;

    /**
    * 排序
    */
    @Column(name = "Seq")
    private Integer seq;

    @Column(name = "V1")
    private BigDecimal v1;

    @Column(name = "V2")
    private BigDecimal v2;

    @Column(name = "A1")
    private BigDecimal a1;

    private static final long serialVersionUID = 1L;
}
