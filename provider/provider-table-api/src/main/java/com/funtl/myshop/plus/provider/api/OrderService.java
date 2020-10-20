package com.funtl.myshop.plus.provider.api;


import com.funtl.myshop.plus.provider.domain.CaseExecList;
import com.funtl.myshop.plus.provider.domain.CaseProList;
import com.funtl.myshop.plus.provider.domain.ThisMonthTar;
import com.funtl.myshop.plus.provider.dto.CaseExecListDto;
import com.funtl.myshop.plus.provider.dto.CaseProQueryParam;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;
import com.funtl.myshop.plus.provider.dto.MonGoalQueryParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService{

    /**
     * 案件进度维护查询按钮
     * @param caseProQueryParam
     * @return
     */
    List<CaseProList> selectCaseProList(CaseProQueryParam caseProQueryParam);

    /**
     *案件维护汇出表格数据
     * @param caseProQueryParam
     * @return
     */
    List<CaseExecList> selectCaseExecList(CaseProQueryParam caseProQueryParam);

//    PageInfo<CaseExecListDto> selectCaseExecListDto(CaseProQueryParam caseProQueryParam);

    /**
     * 周报表当月目标数据
     * @param lineChartQueryParam
     * @return
     */
    ThisMonthTar selectThisMonGoal(LineChartQueryParam lineChartQueryParam);

    /**
     * 周报表当月实绩数据
     * @param monGoalQueryParam
     * @return
     */
    ThisMonthTar selectThisMonReal(MonGoalQueryParam monGoalQueryParam);
}
