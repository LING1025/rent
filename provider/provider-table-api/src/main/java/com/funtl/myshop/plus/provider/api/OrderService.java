package com.funtl.myshop.plus.provider.api;


import com.funtl.myshop.plus.provider.domain.CaseProList;
import com.funtl.myshop.plus.provider.dto.CaseProQueryParam;

import java.util.List;

public interface OrderService{

    /**
     * 案件进度维护查询按钮
     * @param caseProQueryParam
     * @return
     */
    List<CaseProList> selectCaseProList(CaseProQueryParam caseProQueryParam);
}
