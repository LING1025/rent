package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.ModeTwoList;
import com.funtl.myshop.plus.provider.domain.Org;
import com.funtl.myshop.plus.provider.domain.OrgNameList;
import com.funtl.myshop.plus.provider.mapper.OrgMapper;
import com.funtl.myshop.plus.provider.api.OrgService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class OrgServiceImpl implements OrgService{

    @Resource
    private OrgMapper orgMapper;

    @Override
    public List<OrgNameList> selectOrgName(String depName) {
        return orgMapper.selectOrgName(depName);
    }

    @Override
    public Org selectById(Long orgAuto) {
        return orgMapper.selectByPrimaryKey(orgAuto);
    }

    @Override
    public List<ModeTwoList> selectModeOne(Integer isSalesDep, Integer lev, Integer ACLType) {
        return orgMapper.selectModeOne(isSalesDep,lev,ACLType);
    }

    @Override
    public List<ModeTwoList> selectModeTwo(Integer isSalesDep, Integer lev) {
        return orgMapper.selectModeTwo(isSalesDep,lev);
    }

}
