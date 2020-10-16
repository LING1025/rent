package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.CompanyNameList;
import com.funtl.myshop.plus.provider.mapper.IncMapper;
import com.funtl.myshop.plus.provider.api.IncService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class IncServiceImpl implements IncService{

    @Resource
    private IncMapper incMapper;

    @Override
    public List<CompanyNameList> selectCompanyNameList(Integer mode, String searchWord) {
        return incMapper.selectCompanyNameList(mode,searchWord);
    }
}
