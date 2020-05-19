package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.Roles2OrgMapper;
import com.funtl.myshop.plus.provider.domain.Roles2Org;
import com.funtl.myshop.plus.provider.api.Roles2OrgService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class Roles2OrgServiceImpl implements Roles2OrgService{

    @Resource
    private Roles2OrgMapper roles2OrgMapper;

    @Override
    public Integer insert(Roles2Org roles2Org) {
        return roles2OrgMapper.insertSelective(roles2Org);
    }
}
