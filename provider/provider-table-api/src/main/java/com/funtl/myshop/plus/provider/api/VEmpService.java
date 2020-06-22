package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.domain.VEmp;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;

import java.util.List;

public interface VEmpService{
    /**
     * 获取部门/课数据
     * @param lineChartQueryParam
     * @return
     */
    List<ReportForms> selectMode(LineChartQueryParam lineChartQueryParam);

}
