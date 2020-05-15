package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询参数
 */

@Data
public class EmpQueryParam implements Serializable {

    /**
     * 部门名称
     */
    private String orgName;

    /**
     * 员工姓名
     */
    private String fName;

    private Integer pageNum;
    private Integer pageSize;

    public EmpQueryParam(String orgName, String fName, Integer pageNum, Integer pageSize) {
        this.orgName = orgName;
        this.fName = fName;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
