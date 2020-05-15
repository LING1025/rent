package com.funtl.myshop.plus.provider.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.AspnetRolesMapper;
import com.funtl.myshop.plus.provider.api.AspnetRolesService;
@Service
public class AspnetRolesServiceImpl implements AspnetRolesService{

    @Resource
    private AspnetRolesMapper aspnetRolesMapper;

}
