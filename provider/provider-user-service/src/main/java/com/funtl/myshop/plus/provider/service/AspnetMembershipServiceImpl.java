package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.AspnetMembership;
import com.funtl.myshop.plus.provider.mapper.AspnetMembershipMapper;
import com.funtl.myshop.plus.provider.api.AspnetMembershipService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class AspnetMembershipServiceImpl implements AspnetMembershipService{

    @Resource
    private AspnetMembershipMapper aspnetMembershipMapper;

    @Override
    public Object insert(AspnetMembership aspnetMembership) {
        Integer i = aspnetMembershipMapper.insert(aspnetMembership);
        return i == 1 ? aspnetMembership.getUserId() : 0;
    }

    @Override
    public AspnetMembership selectByUserId(Object userId) {
        return aspnetMembershipMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Object deleteByUserId(Object userId) {
        return aspnetMembershipMapper.deleteByPrimaryKey(userId);
    }
}
