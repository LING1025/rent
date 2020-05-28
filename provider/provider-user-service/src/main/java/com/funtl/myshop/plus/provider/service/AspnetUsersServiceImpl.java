package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;import com.funtl.myshop.plus.provider.mapper.AspnetUsersMapper;
import org.apache.dubbo.config.annotation.Service;
import javax.annotation.Resource;

@Service(version = "1.0.0")
public class AspnetUsersServiceImpl implements AspnetUsersService {

    @Resource
    private AspnetUsersMapper aspnetUsersMapper;

    @Override
    public Long insert(AspnetUsers aspnetUsers) {
        Integer i = aspnetUsersMapper.insertUseGeneratedKeys(aspnetUsers);
        return i == 1 ? aspnetUsers.getUserAuto() : 0;
    }

    @Override
    public Integer deleteById(Long userAuto) {
        return aspnetUsersMapper.deleteByPrimaryKey(userAuto);
    }

    @Override
    public Integer update(AspnetUsers aspnetUsers) {
        return aspnetUsersMapper.updateByPrimaryKeySelective(aspnetUsers);
    }

    @Override
    public AspnetUsers selectById(Long userAuto) {
        return aspnetUsersMapper.selectByPrimaryKey(userAuto);
    }
}

