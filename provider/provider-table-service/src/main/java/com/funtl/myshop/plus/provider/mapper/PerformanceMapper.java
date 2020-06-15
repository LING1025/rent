package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.Performance;import com.funtl.myshop.plus.provider.domain.ReportForms;import com.funtl.myshop.plus.provider.dto.RptQueryParam;import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface PerformanceMapper extends MyMapper<Performance> {

    ReportForms selectByYM(@Param("param") RptQueryParam rptQueryParam);

    List<ReportForms> selectByUpId(@Param("year") Integer year, @Param("month") Integer month, @Param("upUnit") Long upUnit);

    List<ReportForms> selectModeOne(@Param("year") Integer year, @Param("month") Integer month,@Param("startDate") String startDate,@Param("endDate") String endDate);

    List<ReportForms> selectModeZero(@Param("year") Integer year, @Param("month") Integer month,@Param("startDate") String startDate,@Param("endDate") String endDate);
}
