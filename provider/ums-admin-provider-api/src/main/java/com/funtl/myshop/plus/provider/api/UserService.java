package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.User;
import com.funtl.myshop.plus.provider.dto.UserListQueryParam;

import java.util.List;

public interface UserService{
    /**
     * 获取用户
     * @param username 用户名
     * @return
     */
    User get(String username);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     * 更新用户
     * 仅允许更新 邮箱、昵称、备注、状态
     * @param user
     * @return
     */
    Integer update(User user);

    /**
     * 修改密码
     * @param username 用户名
     * @param password 明文密码
     * @return
     */
    int modifyPassword(String username, String password);

    User selectById(Integer userId);

    /**
     * 查询员工信息
     * @param userListQueryParam
     * @return
     */
    List<User> selectUserListDto(UserListQueryParam userListQueryParam);

    /**
     * 修改账户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);
}
