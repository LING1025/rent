package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Performance;
import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParam;
import com.funtl.myshop.plus.provider.dto.RptQueryParams;

import java.util.Date;
import java.util.List;

public interface PerformanceService{

    /**
     * 获取下级数据
     * @return
     */
    List<ReportForms> selectModeOnes(RptQueryParam rptQueryParam);

    /**
     * 获取业代数据
     * @return
     */

    List<ReportForms> selectModeZeros(RptQueryParam rptQueryParam);


    ReportForms selectModeTwo(RptQueryParams rptQueryParams);
}
