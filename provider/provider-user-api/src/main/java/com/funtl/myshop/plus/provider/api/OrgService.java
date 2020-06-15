package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Org;
import com.funtl.myshop.plus.provider.domain.Org2Emp;
import com.funtl.myshop.plus.provider.domain.OrgNameList;

import java.util.List;

public interface OrgService{
    /**
     * 获取部门名称
     * @param depName
     * @return
     */
    List<OrgNameList> selectOrgName(String depName);

    /**
     * 根据部门id获取部门信息
     * @param orgAuto
     * @return
     */
    Org selectById(Long orgAuto);


    /**
     * 获取下级课数据
     * @param userAuto
     * @param orgAuto
     * @return
     */
    Org selectModeOne(Long userAuto, Long orgAuto);

    /**
     * 获取部门数据
     * @param userAuto
     * @param orgAuto
     * @return
     */
    Org selectModeTwo(Long userAuto, Long orgAuto);

}
