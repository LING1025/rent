package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OrgGroup;
import com.funtl.myshop.plus.provider.domain.OrgGroupNameList;

import java.util.List;

public interface OrgGroupService{

    /**
     * 获取所属组名称
     * @param orgGroupName
     * @return
     */
    List<OrgGroupNameList> selectOrgGroupName(String orgGroupName);

    /**
     * 根据所属组名称获取所属组信息
     * @param orgGroupName
     * @return
     */
    OrgGroup selectByOrgGroupName(String orgGroupName);

}
