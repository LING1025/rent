package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.Performance;import com.funtl.myshop.plus.provider.domain.ReportForms;import com.funtl.myshop.plus.provider.dto.RptQueryParam;import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface PerformanceMapper extends MyMapper<Performance> {

    ReportForms selectModeTwo(@Param("year") Integer year, @Param("month") Integer month,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("orgAuto") Long orgAuto);

    List<ReportForms> selectModeOnes(@Param("year") Integer year, @Param("month") Integer month,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("orgAutos") List<Long> orgAutos);

    List<ReportForms> selectModeZeros(@Param("year") Integer year, @Param("month") Integer month,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("orgAutos") List<Long> orgAutos);
}
