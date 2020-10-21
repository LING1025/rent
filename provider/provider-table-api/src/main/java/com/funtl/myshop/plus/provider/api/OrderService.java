package com.funtl.myshop.plus.provider.api;


import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
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
     * 周报表新增契约租金-客户来源当月目标数据
     * @param lineChartQueryParam
     * @return
     */
    ThisMonthTar selectThisMonGoal(LineChartQueryParam lineChartQueryParam);

    /**
     * 周报表新增契约租金-客户来源当月实绩数据
     * @param monGoalQueryParam
     * @return
     */
    ThisMonthTar selectThisMonReal(MonGoalQueryParam monGoalQueryParam);

    /**
     * 周报表新增契约租金-车辆来源当月实绩数据
     * @param monGoalQueryParam
     * @return
     */
    CarSourceRent selectCarSourceRent(MonGoalQueryParam monGoalQueryParam);

    /**
     * 周报表新增契约台数-车辆来源当月实绩数据
     * @param monGoalQueryParam
     * @return
     */
    CarSourceRent selectCarSourceNum(MonGoalQueryParam monGoalQueryParam);
}
