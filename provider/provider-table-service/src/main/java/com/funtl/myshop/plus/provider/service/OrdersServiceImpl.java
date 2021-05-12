package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.ProNameList;
import com.funtl.myshop.plus.provider.domain.ProjectList;
import com.funtl.myshop.plus.provider.dto.ProjectQueryParam;
import com.funtl.myshop.plus.provider.mapper.OrdersMapper;
import com.funtl.myshop.plus.provider.api.OrdersService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<ProjectList> selectProList(ProjectQueryParam projectQueryParam) {
        return ordersMapper.selectProList(projectQueryParam);
    }

    @Override
    public List<ProNameList> selectProNameList(String projectName) {
        return ordersMapper.selectProNameList(projectName);
    }
}
