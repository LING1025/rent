package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Org2Emp;
public interface Org2EmpService{

    /**
     * 新增部门员工绑定数据
     * @param org2Emp
     * @return
     */
    Long insert(Org2Emp org2Emp);

    /**
     * 根据主键删除部门员工绑定数据
     * @param org2EmpAuto
     * @return
     */
    Integer deleteById(Long org2EmpAuto);

}
