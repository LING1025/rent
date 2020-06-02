package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.ItRequirementFileMapper;
import com.funtl.myshop.plus.provider.domain.ItRequirementFile;
import com.funtl.myshop.plus.provider.api.ItRequirementFileService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class ItRequirementFileServiceImpl implements ItRequirementFileService{

    @Resource
    private ItRequirementFileMapper itRequirementFileMapper;


}
