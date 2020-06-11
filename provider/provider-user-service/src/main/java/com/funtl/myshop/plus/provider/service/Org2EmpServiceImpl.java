package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.Org2EmpMapper;
import com.funtl.myshop.plus.provider.domain.Org2Emp;
import com.funtl.myshop.plus.provider.api.Org2EmpService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class Org2EmpServiceImpl implements Org2EmpService{

    @Resource
    private Org2EmpMapper org2EmpMapper;


    @Override
    public Long insert(Org2Emp org2Emp) {
        Integer i = org2EmpMapper.insertUseGeneratedKeys(org2Emp);
        return i == 1 ? org2Emp.getOrg2EmpAuto() : 0;
    }

    @Override
    public Integer deleteById(Long org2EmpAuto) {
        return org2EmpMapper.deleteByPrimaryKey(org2EmpAuto);
    }

    @Override
    public Integer update(Org2Emp org2Emp) {
        return org2EmpMapper.updateByPrimaryKeySelective(org2Emp);
    }

    @Override
    public Org2Emp selectByUserAuto(Long userAuto) {
        Example example = new Example(Org2Emp.class);
        example.createCriteria().andEqualTo("userAuto",userAuto);
        return org2EmpMapper.selectOneByExample(example);
    }

    @Override
    public List<Org2Emp> selectType(Integer ACLType) {
        Example example = new Example(Org2Emp.class);
        example.createCriteria().andEqualTo("ACLType",ACLType);
        return org2EmpMapper.selectByExample(example);
    }

}
