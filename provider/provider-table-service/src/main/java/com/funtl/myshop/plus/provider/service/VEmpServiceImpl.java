package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.domain.AgentList;
import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.LastMonthListDto;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.dto.MonthListDto;
import com.funtl.myshop.plus.provider.mapper.VEmpMapper;
import com.funtl.myshop.plus.provider.domain.VEmp;
import com.funtl.myshop.plus.provider.api.VEmpService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class VEmpServiceImpl implements VEmpService{

    @Resource
    private VEmpMapper vEmpMapper;

    @Override
    public List<ReportForms> selectMode(LineChartQueryParam lineChartQueryParam) {
        return vEmpMapper.selectMode(lineChartQueryParam);
    }

    @Override
    public List<MonthListDto> selectTest(LineChartQueryParam lineChartQueryParam) {
        return vEmpMapper.selectTest(lineChartQueryParam);
    }

    @Override
    public VEmp selectByUserAuto(Long userAuto) {
        Example example = new Example(VEmp.class);
        example.createCriteria().andEqualTo("userAuto",userAuto);
        return vEmpMapper.selectOneByExample(example);
    }

    @Override
    public List<AgentList> selectAgentList(Long userAuto) {
        return vEmpMapper.selectAgentList(userAuto);
    }
}
