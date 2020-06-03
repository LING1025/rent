package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.funtl.myshop.plus.provider.domain.UserList;
import com.funtl.myshop.plus.provider.dto.UserListQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface AspnetUsersMapper extends MyMapper<AspnetUsers> {
    List<UserList> selectUserListDto(@Param("param") UserListQueryParam userListQueryParam);
}
