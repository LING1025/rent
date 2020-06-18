package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.Performance;
import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParam;
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
    public List<ReportForms> selectModeOnes(Integer year, Integer month, String startDate, String endDate, List<Long> orgAutos) {
        return performanceMapper.selectModeOnes(year,month,startDate,endDate,orgAutos);

    }

    @Override
    public List<ReportForms> selectModeZeros(Integer year, Integer month, String startDate, String endDate, List<Long> orgAutos) {
        return performanceMapper.selectModeZeros(year,month,startDate,endDate,orgAutos);
    }

    @Override
    public ReportForms selectModeTwo(Integer year, Integer month, String startDate, String endDate,Long orgAuto) {
        return performanceMapper.selectModeTwo(year,month,startDate,endDate,orgAuto);
    }
}
