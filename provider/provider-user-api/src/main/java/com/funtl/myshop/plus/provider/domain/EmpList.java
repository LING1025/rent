package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class EmpList implements Serializable {
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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date mDT;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date cDT;

    private Integer isBoss;

    private Long orgAuto;

    private Integer incTitleAuto;

    /**
     * 角色集合
     */
    private List<EmpRoleName> roles;

    /**
     * 组id
     */
    private Long orgGroupAuto;

    /**
     * 组名称
     */
    private String orgGroupName;

    private String mobilePIN;

    private String email;
}
