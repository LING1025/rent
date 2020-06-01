package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.Roles2Emp;
import com.funtl.myshop.plus.provider.mapper.Roles2EmpMapper;
import com.funtl.myshop.plus.provider.api.Roles2EmpService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class Roles2EmpServiceImpl implements Roles2EmpService{

    @Resource
    private Roles2EmpMapper roles2EmpMapper;

    @Override
    public Long insert(Roles2Emp roles2Emp) {
        Integer i = roles2EmpMapper.insertUseGeneratedKeys(roles2Emp);
        return i == 1 ? roles2Emp.getRoles2EmpAuto() : 0;
    }

    @Override
    public Integer deleteById(Long roles2EmpAuto) {
        return roles2EmpMapper.deleteByPrimaryKey(roles2EmpAuto);
    }

    @Override
    public Integer deleteByEmpAuto(Long empBaseAuto) {
        Example example = new Example(Roles2Emp.class);
        example.createCriteria().andEqualTo("empBaseAuto",empBaseAuto);
        return roles2EmpMapper.deleteByExample(example);
    }
}
