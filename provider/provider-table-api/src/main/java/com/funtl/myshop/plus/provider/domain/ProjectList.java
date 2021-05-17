package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "专案明细")
public class ProjectList implements Serializable {
    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "客户名称")
    private String customer;

    @ApiModelProperty(value = "部门")
    private String depName;

    @ApiModelProperty(value = "业代")
    private String ydName;

    @ApiModelProperty(value = "状态")
    private String orderStatusN;

    @ApiModelProperty(value = "公司别")
    private String incName;

    @ApiModelProperty(value = "厂牌")
    private String brandName;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "案件别")
    private String postTypeN;

    @ApiModelProperty(value = "车辆来源")
    private String carSourceN;

    @ApiModelProperty(value = "业务类别")
    private String orderTypeN;

    @ApiModelProperty(value = "客户来源")
    private String custSourceN;

    @ApiModelProperty(value = "月租金")
    private BigDecimal mAmt;

    @ApiModelProperty(value = "期数")
    private Integer mm;

    @ApiModelProperty(value = "建档日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    @ApiModelProperty(value = "专案名")
    private String projectName;

    @ApiModelProperty(value = "保证金比例")
    private String bzjRate;

    @ApiModelProperty(value = "成交利率")
    private String rentRate;

    @ApiModelProperty(value = "客户评级")
    private String incLev;

    @ApiModelProperty(value = "企业类别")
    private String cusTypeN;

    @ApiModelProperty(value = "成立日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date comEstDate;

    @ApiModelProperty(value = "注册资本额")
    private String comMoney;

    @ApiModelProperty(value = "产业类别")
    private String industryCodeN;

    @ApiModelProperty(value = "设立地址")
    private String createAddress;

    @ApiModelProperty(value = "负责人")
    private String bossName;

    @ApiModelProperty(value = "年龄")
    private Integer bossAge;

    @ApiModelProperty(value = "籍贯")
    private String bossNativePlace;

    @ApiModelProperty(value = "学历")
    private String bossEducationN;

    @ApiModelProperty(value = "婚姻状况")
    private String bossMaritalStatusN;

    @ApiModelProperty(value = "工作年限")
    private String bossWorkingYearsN;

    @ApiModelProperty(value = "保人(是否有)")
    private String isGuarantor;

    @ApiModelProperty(value = "车辆用途")
    private String carUser;

    @ApiModelProperty(value = "入账日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date realIncomeDT;

    @ApiModelProperty(value = "入金件数")
    private Integer goldNum;
}
