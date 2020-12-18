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
     * 周报表新增契约租金,台数-车辆来源当月实绩数据
     * @param monGoalQueryParam
     * @return
     */
    CarSourceRent selectCarSourceRent(MonGoalQueryParam monGoalQueryParam);

    /**
     * 新增保有客户台数
     * @param cusQueryParam
     * @return
     */
    CustomerNum selectCustomerNum(CusQueryParam cusQueryParam);

    /**
     * 前月保有、结清客户台数
     * @param cusQueryParam
     * @return
     */
    CustomerNum selectLm(CusQueryParam cusQueryParam);

    /**
     * 年度新增呆账&回收数据
     * @param year
     * @return
     */
    List<YearList> selectYearList(String year,String week);
}
