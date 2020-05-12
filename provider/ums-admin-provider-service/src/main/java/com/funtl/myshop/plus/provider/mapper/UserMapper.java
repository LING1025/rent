package com.funtl.myshop.plus.provider.mapper;


import com.funtl.myshop.plus.provider.domain.User;
import tk.mybatis.mapper.MyMapper;

public interface UserMapper extends MyMapper<User> {
    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer insertUserList(User user);
}
