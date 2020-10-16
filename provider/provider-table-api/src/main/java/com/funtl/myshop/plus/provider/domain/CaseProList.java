package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "案件进度维护数据")
public class CaseProList implements Serializable {
    @ApiModelProperty(value = "公司别")
    private String companyName;

    @ApiModelProperty(value = "部门")
    private String depName;

    @ApiModelProperty(value = "业务员")
    private String fName;

    @ApiModelProperty(value = "客户名称")
    private String custName;

    @ApiModelProperty(value = "客户简称")
    private String sName;

    @ApiModelProperty(value = "汽车品牌")
    private String clasenName;

    @ApiModelProperty(value = "牌照")
    private String makNo;

    @ApiModelProperty(value = "契约单号")
    private Long orderAuto;

    @ApiModelProperty(value = "客户来源")
    private String custSourceName;

    @ApiModelProperty(value = "租赁性质")
    private String rentTypeName;

    @ApiModelProperty(value = "业务类别")
    private String orderTypeName;

    @ApiModelProperty(value = "车辆牌价")
    private BigDecimal listPrice;

    @ApiModelProperty(value = "租期")
    private Integer mm;

    @ApiModelProperty(value = "月租金")
    private BigDecimal mAmt;

    @ApiModelProperty(value = "总租金")
    private BigDecimal salesAMT;

    @ApiModelProperty(value = "奖金利率")
    private BigDecimal bonusRate;

    @ApiModelProperty(value = "月维修费")
    private BigDecimal carMtnAmt;

    @ApiModelProperty(value = "拨款日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDT;

    @ApiModelProperty(value = "保证金入账日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date realDptDT;

    @ApiModelProperty(value = "领牌日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date makDT;

    @ApiModelProperty(value = "交车日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date jcDT;

    @ApiModelProperty(value = "合约用印日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date contractSignet;

    @ApiModelProperty(value = "奖金日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date boundDT;

    @ApiModelProperty(value = "业绩日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date yjcDT;

    @ApiModelProperty(value = "状态")
    private String orderStatus;

    @ApiModelProperty(value = "贷款金额")
    private BigDecimal qiPiao;

    @ApiModelProperty(value = "类别")
    private String isTruck;

    @ApiModelProperty(value = "保险期数")
    private Integer insureMM;

    @ApiModelProperty(value = "保险金额")
    private BigDecimal insureAmt;

    @ApiModelProperty(value = "奖金发放 0未选中 1已选中")
    private Integer chkBonusStatus;

    /**
     * 用于判断奖金发放
     */
    @JsonIgnore
    private Integer bonusStatus;
}
