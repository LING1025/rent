package com.funtl.myshop.plus.provider.api;


import com.funtl.myshop.plus.provider.domain.CaseExecList;
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

    /**
     *案件维护汇出表格数据
     * @param caseProQueryParam
     * @return
     */
    List<CaseExecList> selectCaseExecList(CaseProQueryParam caseProQueryParam);
}
