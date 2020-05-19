package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.Org2EmpMapper;
import com.funtl.myshop.plus.provider.domain.Org2Emp;
import com.funtl.myshop.plus.provider.api.Org2EmpService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class Org2EmpServiceImpl implements Org2EmpService{

    @Resource
    private Org2EmpMapper org2EmpMapper;


    @Override
    public Integer insert(Org2Emp org2Emp) {
        return org2EmpMapper.insertSelective(org2Emp);
    }
}
