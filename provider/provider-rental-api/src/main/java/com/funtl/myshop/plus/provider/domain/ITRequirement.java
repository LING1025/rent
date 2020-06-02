package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[ITRequirement]")
public class ITRequirement implements Serializable {
    /**
    * 需求单号
    */
    @Id
    @Column(name = "ITRequirement_Auto")
    private Long iTRequirementAuto;

    @Column(name = "User_Auto")
    private Long userAuto;

    /**
    * 希望完成日期
    */
    @Column(name = "ExpectDT")
    private Date expectDT;

    /**
    * 分类1：1:A程式2:B资料3:C专案4:D账号开通5:E硬件维护6:F软件维护
    */
    @Column(name = "Type")
    private Integer type;

    /**
    * 内容
    */
    @Column(name = "Contents")
    private String contents;

    /**
    * 预估工时
    */
    @Column(name = "PlanHours")
    private BigDecimal planHours;

    /**
    * 预估开始日期
    */
    @Column(name = "PlanStartDT")
    private Date planStartDT;

    /**
    * 预估完成日期
    */
    @Column(name = "PlanEndDT")
    private Date planEndDT;

    /**
    * 实际工时
    */
    @Column(name = "RealHours")
    private BigDecimal realHours;

    /**
    * 实际开始日期
    */
    @Column(name = "RealStartDT")
    private Date realStartDT;

    /**
    * 实际完成日期
    */
    @Column(name = "RealEndDT")
    private Date realEndDT;

    /**
    * 负责人员
    */
    @Column(name = "Handler")
    private Long handler;

    @Column(name = "HandlerSign")
    private Integer handlerSign;

    /**
    * 处理情形
    */
    @Column(name = "HandlerContents")
    private String handlerContents;

    /**
    * 建议
    */
    @Column(name = "Memo")
    private String memo;

    @Column(name = "CUser")
    private Long cUser;

    @Column(name = "CDT")
    private Date cDT;

    @Column(name = "MUser")
    private Long mUser;

    @Column(name = "MDT")
    private Date mDT;

    /**
    * 状态：1需处理 2未完成 3已完成
    */
    @Column(name = "Status")
    private Integer status;

    /**
    * 签核列表
    */
    @Column(name = "FlowList")
    private String flowList;

    /**
    * 分类2：1.新增2.修改3.报表
    */
    @Column(name = "Mode")
    private Integer mode;

    /**
    * 异动原因：1.作业需求2.客户要求3.人为疏失
    */
    @Column(name = "Reason")
    private Integer reason;

    /**
    * 程度：1.急件2.重要3.普通
    */
    @Column(name = "Degree")
    private Integer degree;

    /**
    * 业务类型1：需求单2: 签呈
    */
    @Column(name = "OperationType")
    private Integer operationType;

    /**
    * 标题
    */
    @Column(name = "Subject")
    private String subject;

    @Column(name = "IncType")
    private Integer incType;

    @Column(name = "OrgType")
    private Integer orgType;

    @Column(name = "Num")
    private Integer num;

    @Column(name = "Inc_Auto")
    private Integer incAuto;

    @Column(name = "HandlerDep")
    private Integer handlerDep;

    private static final long serialVersionUID = 1L;
}
