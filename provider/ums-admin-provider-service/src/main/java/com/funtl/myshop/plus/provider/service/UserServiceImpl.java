package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.domain.User;
import com.funtl.myshop.plus.provider.dto.UserListQueryParam;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.mapper.UserMapper;
import com.funtl.myshop.plus.provider.api.UserService;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User get(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public Integer insert(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.insertUserList(user);
    }

    @Override
    public Integer update(User user) {
        // 获取原始用户信息
        User oldUser = get(user.getUsername());

        // 仅更新 邮箱、昵称、备注、状态
        oldUser.setSex(user.getSex());
        oldUser.setPhone(user.getPhone());
        oldUser.setAge(user.getAge());
        oldUser.setIsAdmin(user.getIsAdmin());
        oldUser.setStatus(user.getStatus());
        return userMapper.updateByPrimaryKey(oldUser);
    }

    @Override
    public int modifyPassword(String username, String password) {
        User umsAdmin = get(username);
        umsAdmin.setPassword(passwordEncoder.encode(password));
        return userMapper.updateByPrimaryKey(umsAdmin);
    }

    @Override
    public User selectById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> selectUserListDto(UserListQueryParam userListQueryParam) {
        /*Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria()
                .andEqualTo("isAdmin",userListQueryParam.getIsAdmin())
                .andEqualTo("status",userListQueryParam.getStatus());
        if(StringUtil.isNotEmpty(userListQueryParam.getUsername())){
            criteria.andLike("username",String.format("%s%s%s","%",userListQueryParam.getUsername(),"%"));
        }
        return userMapper.selectByExample(example);*/
        return userMapper.selectUserListDto(userListQueryParam);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
