package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OrgGroupNameList;

import java.util.List;

public interface OrgGroupService{

    /**
     * 获取所属组名称
     * @param orgGroupName
     * @return
     */
    List<OrgGroupNameList> selectOrgGroupName(String orgGroupName);

}
