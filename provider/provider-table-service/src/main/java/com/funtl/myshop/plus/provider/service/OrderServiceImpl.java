package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.commons.utils.PageInfoUtils;
import com.funtl.myshop.plus.provider.api.OrderService;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
import com.funtl.myshop.plus.provider.mapper.OrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<CaseProList> selectCaseProList(CaseProQueryParam caseProQueryParam) {
        return orderMapper.selectCaseProList(caseProQueryParam);
    }

    @Override
    public List<CaseExecList> selectCaseExecList(CaseProQueryParam caseProQueryParam) {
        return orderMapper.selectCaseExecList(caseProQueryParam);
    }

    @Override
    public ThisMonthTar selectThisMonGoal(LineChartQueryParam lineChartQueryParam) {
        return orderMapper.selectThisMonGoal(lineChartQueryParam);
    }

    @Override
    public ThisMonthTar selectThisMonReal(MonGoalQueryParam monGoalQueryParam) {
        return orderMapper.selectThisMonReal(monGoalQueryParam);
    }

    @Override
    public CarSourceRent selectCarSourceRent(MonGoalQueryParam monGoalQueryParam) {
        return orderMapper.selectCarSourceRent(monGoalQueryParam);
    }

    @Override
    public CustomerNum selectCustomerNum(CusQueryParam cusQueryParam) {
        return orderMapper.selectCustomerNum(cusQueryParam);
    }

    @Override
    public CustomerNum selectLm(CusQueryParam cusQueryParam) {
        return orderMapper.selectLm(cusQueryParam);
    }

    @Override
    public List<YearList> selectYearList(String year) {
        return orderMapper.selectYearList(year);
    }

    /*@Override
    public PageInfo<CaseExecListDto> selectCaseExecListDto(CaseProQueryParam caseProQueryParam) {
        PageHelper.startPage(caseProQueryParam.getPageNum(),caseProQueryParam.getPageSize());
        PageInfo<CaseExecList> pageInfo = new PageInfo<>(orderMapper.selectCaseExecListDto(caseProQueryParam));
        PageInfo<CaseExecListDto> result = PageInfoUtils.pageInfo2PageInfoDTO(pageInfo,CaseExecListDto.class);
        return result;
    }*/
}
