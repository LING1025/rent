package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class AspUserTest implements Serializable {
    @Column(name = "UserId")
    private Object userId;

    @Column(name = "ApplicationId")
    private Object applicationId;

    /**
     * 用户名
     */
    @Column(name = "UserName")
    private String username;

    /**
     * 小写用户名
     */
    @Column(name = "LoweredUserName")
    private String loweredUserName;

    @Column(name = "MobileAlias")
    private String mobileAlias;

    @Column(name = "IsAnonymous")
    private Boolean isAnonymous;

    /**
     * 最后一次活动日期
     */
    @Column(name = "LastActivityDate")
    private Date lastActivityDate;

    /**
     * 用户id
     */
    @Id
    @Column(name = "User_Auto")
    private Long userAuto;

    @Column(name = "EXTN")
    private String extn;

    @Column(name = "IsEas")
    private Integer isEas;

    /**
     * 分机
     */
    @Column(name = "MobilePIN")
    private String mobilePIN;

    /**
     * 邮箱
     */
    @Column(name = "Email")
    private String email;

    /**
     * 密码
     */
    @Column(name = "Password")
    private String password;

    /**
     * 员工id
     */
    @Column(name = "EmpBase_Auto")
    private Long empBaseAuto;

    /**
     * 启用状态0停用 1启用 2删除
     */
    @Column(name = "IsOn")
    private Integer isOn;

    /**
     * 修改日期
     */
    @Column(name = "MDT")
    private Date mDT;

    /**
     * 创建日期
     */
    @Column(name = "CDT")
    private Date cDT;
}
