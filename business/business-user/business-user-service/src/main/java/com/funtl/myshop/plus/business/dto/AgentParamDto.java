package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "代理人数据")
public class AgentParamDto implements Serializable {
    /**
     * 代理人绑定表id
     */
    @ApiModelProperty(value = "代理人绑定表id")
    private Long creditAgentAuto;

    /**
     * 本人
     */
    @ApiModelProperty(value = "本人id")
    private Long selfUser;

    /**
     * 本人单位
     */
    @ApiModelProperty(value = "本人单位id")
    private Long selfUSerDept;

    /**
     * 代理人
     */
    @ApiModelProperty(value = "代理人id")
    private Long agentUser;

    /**
     * 代理人部门
     */
    @ApiModelProperty(value = "代理人部门id")
    private Long agentUserDept;

    /**
     * 是否有效 0 停用  1正常 2删除
     */
    @ApiModelProperty(value = "是否有效 0 停用  1正常 2删除")
    private Byte isOn;

    /**
     * 代理截止日期
     */
    @ApiModelProperty(value = "代理截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date agentCDate;
}
