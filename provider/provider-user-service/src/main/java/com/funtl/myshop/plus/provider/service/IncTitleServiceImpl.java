package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.IncTitleMapper;
import com.funtl.myshop.plus.provider.domain.IncTitle;
import com.funtl.myshop.plus.provider.api.IncTitleService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class IncTitleServiceImpl implements IncTitleService{

    @Resource
    private IncTitleMapper incTitleMapper;


    @Override
    public IncTitle selectById(Integer incTitleAuto) {
        return incTitleMapper.selectByPrimaryKey(incTitleAuto);
    }
}
