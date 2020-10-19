package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.commons.utils.PageInfoUtils;
import com.funtl.myshop.plus.provider.api.OrderService;
import com.funtl.myshop.plus.provider.domain.CaseExecList;
import com.funtl.myshop.plus.provider.domain.CaseProList;
import com.funtl.myshop.plus.provider.domain.ThisMonthTar;
import com.funtl.myshop.plus.provider.dto.CaseExecListDto;
import com.funtl.myshop.plus.provider.dto.CaseProQueryParam;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;
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
    public List<ThisMonthTar> selectByDate(LineChartQueryParam lineChartQueryParam) {
        return orderMapper.selectByDate(lineChartQueryParam);
    }

    /*@Override
    public PageInfo<CaseExecListDto> selectCaseExecListDto(CaseProQueryParam caseProQueryParam) {
        PageHelper.startPage(caseProQueryParam.getPageNum(),caseProQueryParam.getPageSize());
        PageInfo<CaseExecList> pageInfo = new PageInfo<>(orderMapper.selectCaseExecListDto(caseProQueryParam));
        PageInfo<CaseExecListDto> result = PageInfoUtils.pageInfo2PageInfoDTO(pageInfo,CaseExecListDto.class);
        return result;
    }*/
}
