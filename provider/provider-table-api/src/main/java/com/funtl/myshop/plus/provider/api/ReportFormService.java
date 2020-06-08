package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParams;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReportFormService {
    List<ReportForms> getRptQ(RptQueryParams rptQueryParams);
}
