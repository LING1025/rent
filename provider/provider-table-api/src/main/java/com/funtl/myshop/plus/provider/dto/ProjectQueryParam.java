package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 专案明细查询参数
 */
@Data
public class ProjectQueryParam implements Serializable {
    /**
     * 开始时间
     */
    private String startDT;

    /**
     * 结束时间
     */
    private String endDT;

    /**
     * 专案名称
     */
    private String projectName;
}
