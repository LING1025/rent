package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[Orders]")
public class Orders implements Serializable {
    /**
    * 试算单号
    */
    @Id
    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    /**
    * 公司别代码::Inc.Inc_Auto
    */
    @Column(name = "Inc_Auto")
    private Long incAuto;

    /**
    * 客户代码::TradeItem.TradeItem_Auto
    */
    @Column(name = "TradeItem_Auto")
    private Long tradeItemAuto;

    /**
    * 车号代码::CarBase.CarBase_Auto
    */
    private Long carBaseAuto;

    /**
    * 业代::v_Emp2Role.UserId
    */
    @Column(name = "Sales_Auto")
    private Long salesAuto;

    /**
    * 客户来源::ItemCode.ItemType=313
    */
    @Column(name = "CustSource")
    private Integer custSource;

    private String custMemo;

    /**
    * 车辆来源::ItemCode.ItemType=503
    */
    private Integer carSource;

    /**
    * 品牌::FactoryBrand_Auto
    */
    private Integer factoryBrandAuto;

    /**
    * 厂牌::Brand.Brand_Auto
    */
    private Integer brandAuto;

    /**
    * 车型::Clasen.Clasen_Auto
    */
    private Integer clasenAuto;

    /**
    * 车型代码
    */
    private String clasenCode;

    /**
    * 车色
    */
    private String carColor;

    /**
    * 出厂年月
    */
    private Date carDT;

    /**
    * 排气量
    */
    private Integer cc;

    /**
    * 车号
    */
    private String makNo;

    /**
    * 牌价
    */
    private BigDecimal listPrice;

    /**
    * 折价
    */
    private BigDecimal disPrice;

    /**
    * 进价
    */
    private BigDecimal getPrice;

    /**
    * 配件金额
    */
    private BigDecimal accessary;

    /**
    * 佣金
    */
    private BigDecimal pushMoney;

    private String pushMan;

    private Integer pushManAuto;

    private String pushTEL;

    /**
    * 购置税
    */
    private BigDecimal carTax;

    /**
    * 车辆成本
    */
    private BigDecimal carCost;

    /**
    * 残值
    */
    private BigDecimal overAmt;

    /**
    * 保证金
    */
    private BigDecimal dptAmt;

    /**
    * 上海牌
    */
    private Integer makNoType;

    /**
    * 购牌费
    */
    private BigDecimal makNoCost;

    /**
    * 业务类别::ItemCode.ItemType=326
    */
    private Integer orderType;

    /**
    * 期数
    */
    private Integer mm;

    /**
    * 承租车价
    */
    private BigDecimal rentAmt;

    /**
    * 租赁性质::ItemCode.ItemType=314
    */
    private Integer rentType;

    /**
    * 印花税
    */
    private BigDecimal stampTax;

    /**
    * 售车税
    */
    private BigDecimal sellCarTax;

    /**
    * 过户费
    */
    private BigDecimal trnsFee;

    /**
    * 付款周期::ItemCode.ItemType=316
    */
    private Integer payMode;

    /**
    * 付款天数
    */
    private Integer payDay;

    /**
    * 车险性质别::ItemCode.ItemType=411
    */
    private Integer insureType;

    /**
    * 车險座位别::1.客车6座以下 2.客车6-10座 3.货车2吨以下 4.货车2-5吨
    */
    private Integer insurePercnt;

    /**
    * 座位数
    */
    private Integer percnt;

    /**
    * 汽车产地::1.国产 2.进口
    */
    private Integer carPlace;

    /**
    * 计价成本利率(%)::13
    */
    private BigDecimal rateRate;

    /**
    * 实际成交价利率(%)
    */
    private BigDecimal finalRate;

    private BigDecimal rateMCost;

    private BigDecimal rateYCost;

    private BigDecimal rateTCost;

    private BigDecimal rateM;

    private BigDecimal rateY;

    private BigDecimal rateT;

    private BigDecimal rateCost;

    /**
    * 折旧月租金
    */
    private BigDecimal rateDPN;

    private BigDecimal rateTax;

    private BigDecimal rateAmt;

    private BigDecimal finalMCost;

    private BigDecimal finalYCost;

    private BigDecimal finalTCost;

    private BigDecimal finalM;

    private BigDecimal finalY;

    private BigDecimal finalT;

    private BigDecimal finalCost;

    private BigDecimal finalDPN;

    private BigDecimal finalTax;

    private BigDecimal finalAmt;

    private BigDecimal mAmt;

    private BigDecimal rentAmtT;

    private BigDecimal rentRate;

    private BigDecimal grossMargin;

    private BigDecimal grossMarginT;

    /**
    * 试算报价状态20
    */
    @Column(name = "OrderStatus")
    private Integer orderStatus;

    private String memo;

    private Integer taxMode;

    /**
    * 税率
    */
    private BigDecimal taxRate;

    private Integer chkListPrice;

    /**
     * 建立人
     */
    @Column(name = "CUser")
    private Integer cUser;

    /**
     * 建立時間
     */
    @Column(name = "CDT")
    private Date cDT;

    /**
     * 修改人
     */
    @Column(name = "MUser")
    private Integer mUser;

    /**
     * 修改時間
     */
    @Column(name = "MDT")
    private Date mDT;

    private Integer linceKM;

    private Date appDate;

    /**
    * 附件1
    */
    private String a1;

    /**
    * 附件2
    */
    private String a2;

    /**
    * 附件3
    */
    private String a3;

    /**
    * 附件4
    */
    private String a4;

    /**
    * 附件5
    */
    private String a5;

    /**
    * 原试算单号
    */
    private Long ordersOld;

    /**
    * 报价件类型4
    */
    @Column(name = "PostType")
    private Integer postType;

    private Integer iSContractLock;

    private Long lockUser;

    private Date lockDT;

    private Integer iSThirdParty;

    private Integer bsType;

    private Integer noInsure;

    private BigDecimal iRR;

    private BigDecimal nPV;

    private Integer isCredit;

    private Integer isCreditUser;

    private Integer dptType;

    private Integer supplierBuy;

    private Long projectAuto;

    private Integer onetime;

    private BigDecimal repurchaseAmt;

    private Integer iSInsureOffer;

    private BigDecimal costAdjustment;

    /**
    * 首付款开票付款方式::ItemCode.ItemType=333
    */
    private Integer dptTaxPay;

    /**
    * 代垫利息成本
    */
    private BigDecimal dptTax;

    /**
    * 燃油种类::ItemCode.ItemType=231
    */
    private Integer oil;

    private Integer isCustomerCare;

    /**
    * 续租新车旧车号
    */
    private String reletMakno;

    /**
    * 续租新车否
    */
    private Integer isRelet;

    private BigDecimal onetimeTransfer;

    private BigDecimal onetimePoundage;

    private BigDecimal overAmt_Y;

    private BigDecimal budget01_Y;

    private Integer carTransfer;

    private String makNo_INC;

    private String weight;

    private Integer mm2;

    private Integer useKM;

    /**
    * 服务费
    */
    private BigDecimal serviceAmt;

    /**
    * 出库费
    */
    private BigDecimal outFee;

    /**
    * 金融费
    */
    private BigDecimal financeFee;

    private BigDecimal urgentFee;

    private Integer mortgageAddr;

    private BigDecimal commissionRate;

    private BigDecimal rateTaxY;

    /**
    * 保险报告书
    */
    private String a6;

    /**
    * 保险保单
    */
    private String a7;

    private Integer insureAnomalyType;

    private Long carPriceRef;

    private Integer isBigTradeItem;

    private static final long serialVersionUID = 1L;
}
