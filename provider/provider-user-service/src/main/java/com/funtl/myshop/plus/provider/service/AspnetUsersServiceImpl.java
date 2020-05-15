package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import com.funtl.myshop.plus.provider.mapper.AspnetUsersMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class AspnetUsersServiceImpl implements AspnetUsersService {

    @Resource
    private AspnetUsersMapper aspnetUsersMapper;

}
