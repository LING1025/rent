package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Org2Emp;

import java.util.List;

public interface Org2EmpService{

    /**
     * 新增部门员工绑定数据
     * @param org2Emp
     * @return
     */
    Long insert(Org2Emp org2Emp);


    Integer update(Org2Emp org2Emp);

    /**
     * 根据用户id获取部门员工绑定数据
     * @param userAuto
     * @return
     */
    Org2Emp selectByUserAuto(Long userAuto);

}
