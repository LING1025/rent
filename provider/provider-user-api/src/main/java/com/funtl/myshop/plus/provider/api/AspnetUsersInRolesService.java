package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AspnetUsersInRoles;
public interface AspnetUsersInRolesService{
    /**
     * 插入用户角色绑定信息
     * @param aspnetUsersInRoles
     * @return
     */
    Integer insert(AspnetUsersInRoles aspnetUsersInRoles);

    /**
     * 根据UserId删除用户角色绑定信息
     * @param userId
     * @return
     */
    Integer deleteByUserId(Object userId);

}
