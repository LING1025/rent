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

}
