package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.ReportFormService;
import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParams;
import com.funtl.myshop.plus.provider.mapper.ReportFormMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0")
public class ReportFormServiceImpl implements ReportFormService {
    @Resource
    private ReportFormMapper reportFormMapper;

    @Override
    public List<ReportForms> getRptQ(RptQueryParams rptQueryParams) {
        return reportFormMapper.getRptQ(rptQueryParams);
    }
}
