package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OrgNameList;

import java.util.List;

public interface OrgService{
    /**
     * 获取部门名称
     * @param depName
     * @return
     */
    List<OrgNameList> selectOrgName(String depName);

}
