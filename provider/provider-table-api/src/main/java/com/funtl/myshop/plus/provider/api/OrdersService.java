package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ProjectList;
import com.funtl.myshop.plus.provider.dto.ProjectQueryParam;

import java.util.List;

public interface OrdersService{
    /**
     * 获取专案明细
     * @param projectQueryParam
     * @return
     */
    List<ProjectList> selectProList(ProjectQueryParam projectQueryParam);

}
