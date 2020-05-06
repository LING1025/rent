package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.domain.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.annotation.Resource;
import javax.persistence.Table;

import com.funtl.myshop.plus.provider.mapper.UserMapper;
import com.funtl.myshop.plus.provider.api.UserService;
import tk.mybatis.mapper.entity.Example;

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
        return userMapper.insert(user);
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
        return userMapper.updateByPrimaryKey(oldUser);
    }

    @Override
    public int modifyPassword(String username, String password) {
        User umsAdmin = get(username);
        umsAdmin.setPassword(passwordEncoder.encode(password));
        return userMapper.updateByPrimaryKey(umsAdmin);
    }
}
