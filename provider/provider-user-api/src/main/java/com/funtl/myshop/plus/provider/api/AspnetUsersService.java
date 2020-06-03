package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AspnetUsers;

public interface AspnetUsersService {

    /**
     * 新增用户数据
     * @param aspnetUsers
     * @return
     */
    Long insert(AspnetUsers aspnetUsers);

    /**
     * 根据userAuto删除数据
     * @param userAuto
     * @return
     */
    Integer deleteById(Long userAuto);

    /**
     * 编辑用户数据
     * @param aspnetUsers
     * @return
     */
    Integer update(AspnetUsers aspnetUsers);

    /**
     * 根据userAuto获取用户数据
     * @param userAuto
     * @return
     */
    AspnetUsers selectById(Long userAuto);

    /**
     * 根据员工id获取用户数据
     * @param empBaseAuto
     * @return
     */
    AspnetUsers selectByEmpAuto(Long empBaseAuto);
}

