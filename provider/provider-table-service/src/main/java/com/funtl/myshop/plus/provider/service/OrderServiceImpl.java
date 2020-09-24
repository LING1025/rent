package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.OrderService;
import com.funtl.myshop.plus.provider.domain.CaseProList;
import com.funtl.myshop.plus.provider.dto.CaseProQueryParam;
import com.funtl.myshop.plus.provider.mapper.OrderMapper;
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
}
