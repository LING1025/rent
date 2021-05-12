package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ProNameList;
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

    /**
     * 专案名称下拉选
     * @param projectName
     * @return
     */
    List<ProNameList> selectProNameList(String projectName);
}
