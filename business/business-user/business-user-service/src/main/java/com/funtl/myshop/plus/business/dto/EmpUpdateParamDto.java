package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "编辑员工数据")
public class EmpUpdateParamDto implements Serializable {
    @ApiModelProperty(value = "员工id")
    private Long empBaseAuto;

    @ApiModelProperty(value = "部门id")
    private Long orgAuto;

    @ApiModelProperty(value = "部门名称")
    private String orgName;

    @ApiModelProperty(value = "职位表id")
    private Integer incTitleAuto;

    @ApiModelProperty(value = "职位")
    private String title;

    @ApiModelProperty(value = "启用状态0停用 1启用 2删除")
    private Integer isOn;

    @ApiModelProperty(value = "是否为主管 0否 1是")
    private Integer isBoss;

    @ApiModelProperty(value = "所属组")
    private String orgGroupName;

    @ApiModelProperty(value = "角色名集合")
    private List<String> roles;

    @JsonIgnore
    private Date mDT;

    @JsonIgnore
    private Date cDT;
}
