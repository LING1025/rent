package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 */
@Data
@Table(name = "[aspnet_Users]")
public class AspnetUsers implements Serializable {
    @Column(name = "UserId")
    private Object userId;

    @Column(name = "ApplicationId")
    private Object applicationId;

    /**
     * 用户名
     */
    @Column(name = "UserName")
    private String userName;

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

    @Column(name = "MobilePIN")
    private String mobilePIN;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "EmpBase_Auto")
    private Long empBaseAuto;

    private static final long serialVersionUID = 1L;
}
