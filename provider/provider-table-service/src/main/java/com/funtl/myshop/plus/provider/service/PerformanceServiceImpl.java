package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.Performance;
import com.funtl.myshop.plus.provider.mapper.PerformanceMapper;
import com.funtl.myshop.plus.provider.api.PerformanceService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class PerformanceServiceImpl implements PerformanceService{

    @Resource
    private PerformanceMapper performanceMapper;


}
