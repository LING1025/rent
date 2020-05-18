package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.RolesNameList;

import java.util.List;

public interface AspnetRolesService{
    /**
     * 获取角色名称
     * @param roleName
     * @return
     */
    List<RolesNameList> selectRoleName(String roleName);

}
