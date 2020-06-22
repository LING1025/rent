package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.AspnetUsersInRoles;
import com.funtl.myshop.plus.provider.mapper.AspnetUsersInRolesMapper;
import com.funtl.myshop.plus.provider.api.AspnetUsersInRolesService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

@Service(version = "1.0.0")
public class AspnetUsersInRolesServiceImpl implements AspnetUsersInRolesService{

    @Resource
    private AspnetUsersInRolesMapper aspnetUsersInRolesMapper;

    @Override
    public Integer insert(AspnetUsersInRoles aspnetUsersInRoles) {
        return aspnetUsersInRolesMapper.insertSelective(aspnetUsersInRoles);
    }

    @Override
    public Integer deleteByUserId(Object userId) {
        Example example = new Example(AspnetUsersInRoles.class);
        example.createCriteria().andEqualTo("userId",userId);
        return aspnetUsersInRolesMapper.deleteByExample(example);
    }
}
