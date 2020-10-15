package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[Inc]")
public class Inc implements Serializable {
    /**
    * 公司序号
    */
    @Id
    @Column(name = "Inc_Auto")
    private Long incAuto;

    /**
    * 交易对象序号
    */
    @Column(name = "TradeItem_Auto")
    private Long tradeItemAuto;

    /**
    * 公司全称
    */
    @Column(name = "FName")
    private String fName;

    /**
    * 简称
    */
    @Column(name = "SName")
    private String sName;

    /**
    * 税籍编号
    */
    @Column(name = "TaxCode")
    private String taxCode;

    /**
    * 车辆购置税mode
    */
    @Column(name = "CarTaxMode")
    private Integer carTaxMode;

    /**
    * 汇款账号
    */
    @Column(name = "AccMemo")
    private String accMemo;

    /**
    * 状态
    */
    @Column(name = "Status")
    private Integer status;

    /**
    * 建立时间
    */
    @Column(name = "CDT")
    private Date CDT;

    /**
    * 建立人
    */
    @Column(name = "CUser")
    private Integer CUser;

    /**
    * 修改时间
    */
    @Column(name = "MDT")
    private Date MDT;

    /**
    * 修改人
    */
    @Column(name = "MUser")
    private Integer MUser;

    @Column(name = "IncVirBankNo")
    private String incVirBankNo;

    @Column(name = "IncVirBankNm")
    private String incVirBankNm;

    @Column(name = "oldBankNo")
    private String oldBankNo;

    @Column(name = "oldBankNm")
    private String oldBankNm;

    @Column(name = "LicensePlate")
    private String licensePlate;

    @Column(name = "EASCode")
    private String eASCode;

    @Column(name = "ISLimitedLicense")
    private Integer iSLimitedLicense;

    /**
    * 区
    */
    @Column(name = "Area")
    private Integer area;

    /**
    * 设立地址
    */
    @Column(name = "Inc_Addr")
    private String incAddr;

    /**
    * 电话
    */
    @Column(name = "Inc_Tel")
    private String incTel;

    /**
    * 传真
    */
    @Column(name = "Inc_Fax")
    private String incFax;

    /**
    * 城市编码
    */
    @Column(name = "CityCode")
    private String cityCode;

    /**
    * 业务类别一般件抵押日期天数
    */
    @Column(name = "Mortgage")
    private Integer mortgage;

    private static final long serialVersionUID = 1L;
}
