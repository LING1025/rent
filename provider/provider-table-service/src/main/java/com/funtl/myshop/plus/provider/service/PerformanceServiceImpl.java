package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.Performance;
import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParam;
import com.funtl.myshop.plus.provider.dto.RptQueryParams;
import com.funtl.myshop.plus.provider.mapper.PerformanceMapper;
import com.funtl.myshop.plus.provider.api.PerformanceService;
import org.apache.dubbo.config.annotation.Service;

import java.util.Date;
import java.util.List;

@Service(version = "1.0.0")
public class PerformanceServiceImpl implements PerformanceService{

    @Resource
    private PerformanceMapper performanceMapper;

    @Override
    public List<ReportForms> selectModeOnes(RptQueryParam rptQueryParam) {
        return performanceMapper.selectModeOnes(rptQueryParam);

    }

    @Override
    public List<ReportForms> selectModeZeros(RptQueryParam rptQueryParam) {
        return performanceMapper.selectModeZeros(rptQueryParam);
    }

    @Override
    public ReportForms selectModeTwo(RptQueryParams rptQueryParams) {
        return performanceMapper.selectModeTwo(rptQueryParams);
    }
}
