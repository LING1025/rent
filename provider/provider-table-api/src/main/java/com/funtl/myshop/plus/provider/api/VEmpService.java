package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.domain.TrialForms;
import com.funtl.myshop.plus.provider.domain.VEmp;
import com.funtl.myshop.plus.provider.dto.LastMonthListDto;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;
import com.funtl.myshop.plus.provider.dto.MonthListDto;

import java.util.List;

public interface VEmpService{
    /**
     * 获取部门/课数据
     * @param lineChartQueryParam
     * @return
     */
    List<ReportForms> selectMode(LineChartQueryParam lineChartQueryParam);

//    List<TrialForms> selectTrail(LineChartQueryParam lineChartQueryParam);

    List<MonthListDto> selectTrail(LineChartQueryParam lineChartQueryParam);

    List<LastMonthListDto> selectLastMonth(LineChartQueryParam lineChartQueryParam);


}
