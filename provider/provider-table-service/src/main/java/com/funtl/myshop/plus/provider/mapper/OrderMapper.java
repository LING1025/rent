package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrderMapper extends MyMapper<Order> {
    List<CaseProList> selectCaseProList(@Param("param") CaseProQueryParam caseProQueryParam);

    List<CaseExecList> selectCaseExecList(@Param("param")CaseProQueryParam caseProQueryParam);

    ThisMonthTar selectThisMonGoal(@Param("param") LineChartQueryParam lineChartQueryParam);

    ThisMonthTar selectThisMonReal(@Param("param") MonGoalQueryParam monGoalQueryParam);

    CarSourceRent selectCarSourceRent(@Param("param") MonGoalQueryParam monGoalQueryParam);

    CustomerNum selectCustomerNum(@Param("param") CusQueryParam cusQueryParam);

    CustomerNum selectLm(@Param("param") CusQueryParam cusQueryParam);


//    List<CaseExecList> selectCaseExecListDto(@Param("param")CaseProQueryParam caseProQueryParam);
}
