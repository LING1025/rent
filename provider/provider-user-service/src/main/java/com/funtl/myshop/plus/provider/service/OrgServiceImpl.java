package com.funtl.myshop.plus.provider.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.OrgMapper;
import com.funtl.myshop.plus.provider.api.OrgService;
@Service
public class OrgServiceImpl implements OrgService{

    @Resource
    private OrgMapper orgMapper;

}
