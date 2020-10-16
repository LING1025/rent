package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.CaseExecList;
import com.funtl.myshop.plus.provider.domain.CaseProList;
import com.funtl.myshop.plus.provider.domain.Order;
import com.funtl.myshop.plus.provider.dto.CaseProQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrderMapper extends MyMapper<Order> {
    List<CaseProList> selectCaseProList(@Param("caseProQueryParam") CaseProQueryParam caseProQueryParam);

    List<CaseExecList> selectCaseExecList(@Param("param")CaseProQueryParam caseProQueryParam);
}
