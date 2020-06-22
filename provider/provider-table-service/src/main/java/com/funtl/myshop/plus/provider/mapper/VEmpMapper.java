package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.domain.VEmp;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface VEmpMapper extends MyMapper<VEmp> {
    List<ReportForms> selectMode(@Param("param") LineChartQueryParam lineChartQueryParam);
}
