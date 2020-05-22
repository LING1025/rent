package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回属性
 */

@Data
public class EmpListDto implements Serializable {
    /**
     * 员工id
     */
    private Long empBaseAuto;

    /**
     * 部门名称
     */
    private String orgName;

    /**
     * 职位
     */
    private String title;

    /**
     * 员工姓名
     */
    private String fName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 启用状态
     */
    private Integer isOn;

    private Date mDT;

    private Integer mUser;

    private Integer isBoss;

    private Long orgAuto;

    private Integer incTitleAuto;
}
