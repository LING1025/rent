package com.funtl.myshop.plus.provider.mapper;


import com.funtl.myshop.plus.provider.domain.User;
import com.funtl.myshop.plus.provider.dto.UserListQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer insertUserList(User user);

    List<User> selectUserListDto(@Param("param") UserListQueryParam userListQueryParam);
}
