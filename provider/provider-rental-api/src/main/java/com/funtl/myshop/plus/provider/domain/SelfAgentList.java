package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class SelfAgentList implements Serializable {
    /**
     * 代理人绑定表id
     */
    private Long creditAgentAuto;

    /**
     * 本人
     */
    private Long selfUser;
    private String selfName;

    /**
     * 本人单位
     */
    private Long selfUSerDept;
    private String selfDept;

    /**
     * 代理人
     */
    private Long agentUser;
    private String agentName;

    /**
     * 代理人部门
     */
    private Long agentUserDept;
    private String agentDept;

    /**
     * 是否有效 0 停用  1正常 2删除
     */
    private Byte isOn;

    /**
     * 代理截止日期
     */
    private Date agentCDate;
}
