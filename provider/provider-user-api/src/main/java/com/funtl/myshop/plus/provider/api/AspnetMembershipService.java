package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AspnetMembership;
public interface AspnetMembershipService{
    /**
     * aspnet_membership插入数据
     * @param aspnetMembership
     * @return
     */
    Object insert(AspnetMembership aspnetMembership);

    /**
     * 根据UserId查询AspnetMembership数据
     * @param userId
     * @return
     */
    AspnetMembership selectByUserId(Object userId);

    /**
     * 根据UserId删除AspnetMembership数据
     * @param userId
     * @return
     */
    Object deleteByUserId(Object userId);

    Integer update(AspnetMembership aspnetMembership);

    /**
     * 修改密码
     * @param username 用户名
     * @param password 明文密码
     * @return
     */
    Integer modifyPassword(String username, String password);
}
