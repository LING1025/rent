package com.funtl.myshop.plus.provider.mapper;


import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParams;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReportFormMapper extends MyMapper<ReportForms> {
    List<ReportForms> getRptQ(@Param("rptQueryParams") RptQueryParams rptQueryParams);
}
