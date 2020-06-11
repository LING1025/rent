package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "营业报表返回属性")
public class ReportForms implements Serializable {
    @JsonIgnore
    private Long salesAuto;
    /*private Long upUnit;
    private Long orgAuto;*/

    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String orgName;

    /**
     * 目标台数
     */
    @ApiModelProperty(value = "目标台数")
    private Integer targetNum;

    /**
     * 实际台数
     */
    @ApiModelProperty(value = "实际台数")
    private Integer realNum;

    /**
     * 目标报件户数
     */
    @ApiModelProperty(value = "目标报件户数")
    private Integer targetPaperNum;

    /**
     * 试算报件户数
     */
    @ApiModelProperty(value = "试算报件户数")
    private Integer proPaperNum;

    /**
     * 回租报件户数
     */
//    private Integer rentPaperNum;

    /**
     * 目标营业额
     */
    @ApiModelProperty(value = "目标营业额")
    private Integer targetVolume;

    /**
     * 实际营业额
     */
    @ApiModelProperty(value = "实际营业额")
    private Integer realVolume;
/*

    */
/**
     * 租_汰
     *//*

    private Integer rentOut;

    */
/**
     * 租_还
     *//*

    private Integer rentBack;

    */
/**
     * 维修_Y
     *//*

    private Integer maintainNum;

    */
/**
     * 新拓(乘用车)
     *//*

    private Integer extension;

    */
/**
     * 保有
     *//*

    private Integer tenure;

    */
/**
     * 通路介绍（乘用车）
     *//*

    private Integer instrNum;

    */
/**
     * 轻货卡
     *//*

    private Integer carGo;

    */
/**
     * 到_汰
     *//*

    private Integer getOut;
    */
/**
     * 到_还
     *//*

    private Integer getBack;
*/

}
