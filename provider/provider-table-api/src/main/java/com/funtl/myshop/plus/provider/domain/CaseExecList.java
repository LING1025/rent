package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "案件维护汇出数据")
public class CaseExecList implements Serializable {
    @ApiModelProperty(value = "业务单位")
    private String depName;

    @ApiModelProperty(value = "业代")
    private String fName;

    @ApiModelProperty(value = "契约编号")
    private String orderNo;

    @ApiModelProperty(value = "承租人统编")
    private Long tradeItemAuto;

    @ApiModelProperty(value = "公司名称")
    private String comFName;

    @ApiModelProperty(value = "是否是公司")
    private String idenType;

    @ApiModelProperty(value = "所属公司")
    private String sName;

    @ApiModelProperty(value = "状态")
    private String statusName;

    @ApiModelProperty(value = "牌照号码")
    private String makNo;

    @ApiModelProperty(value = "车种")
    private String category;

    @ApiModelProperty(value = "客户来源")
    private String custSource;

    @ApiModelProperty(value = "租赁性质")
    private String rentType;

    @ApiModelProperty(value = "总厂牌")
    private String factoryBrandName;

    @ApiModelProperty(value = "厂牌")
    private String brandName;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "车色")
    private String carColor;

    @ApiModelProperty(value = "经销商")
    private String sellerFName;

    @ApiModelProperty(value = "每月租金")
    private BigDecimal mAmt;

    @ApiModelProperty(value = "总租金=a.MAmt*a.MM ")
    private String totalAmt;

    @ApiModelProperty(value = "领照日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date makDT;

    @ApiModelProperty(value = "牌价")
    private BigDecimal listPrice;

    @ApiModelProperty(value = "进价")
    private BigDecimal getPrice;

    @ApiModelProperty(value = "折价")
    private BigDecimal disPrice;

    @ApiModelProperty(value = "折价率")
    private BigDecimal disPriceTax;

    @ApiModelProperty(value = "配件")
    private BigDecimal accessary;

    @ApiModelProperty(value = "佣金")
    private BigDecimal pushMoney;

    @ApiModelProperty(value = "残值")
    private BigDecimal salvage;

    @ApiModelProperty(value = "保证金")
    private BigDecimal dptAmt;

    @ApiModelProperty(value = "月维修费")
    private BigDecimal carMtnAmt;

    @ApiModelProperty(value = "贷款金额")
    private BigDecimal loanAmount;

    @ApiModelProperty(value = "起租日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDT;

    @ApiModelProperty(value = "到期日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDT;

    @ApiModelProperty(value = "期数")
    private Integer mm;

    @ApiModelProperty(value = "客户评等")
    private String creditLevel;

    @ApiModelProperty(value = "申购单号")
    private Long orderAuto;

    @ApiModelProperty(value = "授信单号")
    private Long creditMainAuto;

    @ApiModelProperty(value = "合约编号")
    private String contractNo;

    @ApiModelProperty(value = "交车日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date forDT;

    @ApiModelProperty(value = "付款方式")
    private String payType;

    @ApiModelProperty(value = "车辆来源")
    private String carSource;

    @ApiModelProperty(value = "成交利率")
    private BigDecimal rentRate;

    @ApiModelProperty(value = "承作利率")
    private BigDecimal finalRate;

    @ApiModelProperty(value = "承作价格")
    private BigDecimal rentAmt;

    @ApiModelProperty(value = "实际利率")
    private BigDecimal bonusRate;

    @ApiModelProperty(value = "业务类别")
    private String businessType;

    @ApiModelProperty(value = "试算业务类别")
    private String businessOrdersType;

    @ApiModelProperty(value = "购置税实付金额")
    private BigDecimal realAmt;

    @ApiModelProperty(value = "配件实付金额")
    private BigDecimal accRealAmt;

    @ApiModelProperty(value = "业绩日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date yjCDT;

    @ApiModelProperty(value = "使用性质")
    private String useType;

    @ApiModelProperty(value = "是否一次性租赁")
    private String onetime;

    @ApiModelProperty(value = "专案")
    private String projectName;

    @ApiModelProperty(value = "货车")
    private String trucks;

    @ApiModelProperty(value = "公司型态")
    private String comType;

    @ApiModelProperty(value = "保险期数")
    private Integer insureMM;

    @ApiModelProperty(value = "保险金额")
    private BigDecimal insureAmt;

    @ApiModelProperty(value = "试算购置税金额")
    private BigDecimal carTax;

    @ApiModelProperty(value = "营业额")
    private BigDecimal inCome;

    @ApiModelProperty(value = "营业成本")
    private BigDecimal carCost;

    @ApiModelProperty(value = "营业费用")
    private BigDecimal budgetAmt;


}
