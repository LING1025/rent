package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.IncMapper;
import com.funtl.myshop.plus.provider.api.IncService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class IncServiceImpl implements IncService{

    @Resource
    private IncMapper incMapper;


}
