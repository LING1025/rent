package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.ITRequirementMapper;
import com.funtl.myshop.plus.provider.api.ITRequirementService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class ITRequirementServiceImpl implements ITRequirementService{

    @Resource
    private ITRequirementMapper iTRequirementMapper;

}
