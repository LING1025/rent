package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.OrgGroupNameList;
import com.funtl.myshop.plus.provider.mapper.OrgGroupMapper;
import com.funtl.myshop.plus.provider.domain.OrgGroup;
import com.funtl.myshop.plus.provider.api.OrgGroupService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class OrgGroupServiceImpl implements OrgGroupService{

    @Resource
    private OrgGroupMapper orgGroupMapper;

    @Override
    public List<OrgGroupNameList> selectOrgGroupName(String orgGroupName) {
        return orgGroupMapper.selectOrgGroupName(orgGroupName);
    }

    @Override
    public OrgGroup selectByOrgGroupName(String orgGroupName) {
        Example example = new Example(OrgGroup.class);
        example.createCriteria().andEqualTo("OrgGroupName",orgGroupName);
        return orgGroupMapper.selectOneByExample(example);
    }
}
