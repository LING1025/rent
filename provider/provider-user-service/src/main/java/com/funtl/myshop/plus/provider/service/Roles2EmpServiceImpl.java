package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.Roles2Emp;
import com.funtl.myshop.plus.provider.mapper.Roles2EmpMapper;
import com.funtl.myshop.plus.provider.api.Roles2EmpService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class Roles2EmpServiceImpl implements Roles2EmpService{

    @Resource
    private Roles2EmpMapper roles2EmpMapper;

    @Override
    public Integer insert(Roles2Emp roles2Emp) {
        return roles2EmpMapper.insertSelective(roles2Emp);
    }
}
