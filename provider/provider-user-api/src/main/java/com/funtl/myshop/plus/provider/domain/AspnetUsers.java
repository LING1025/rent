package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Table;

/**
    * 用户表
    */
@Data
@Table(name = "[aspnet_Users]")
public class AspnetUsers implements Serializable {
    private Object userId;

    private Object applicationId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 小写用户名
    */
    private String loweredUsername;

    private String mobileAlias;

    private Boolean isAnonymous;

    /**
    * 最后一次活动日期
    */
    private Date lastActivityDate;

    /**
    * 用户id
    */
    private Long userAuto;

    private String extn;

    private Integer isEas;

    private static final long serialVersionUID = 1L;
}
