package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AspnetUsers;

public interface AspnetUsersService {

    /**
     * 新增用户数据
     * @param aspnetUsers
     * @return
     */
    Long insert(AspnetUsers aspnetUsers);
}

