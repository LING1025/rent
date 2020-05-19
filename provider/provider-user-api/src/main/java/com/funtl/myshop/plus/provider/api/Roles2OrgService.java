package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Roles2Org;
public interface Roles2OrgService{

    /**
     * 新增部门角色绑定数据
     * @param roles2Org
     * @return
     */
    Integer insert(Roles2Org roles2Org);

}
