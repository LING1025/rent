package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Roles2Emp;
public interface Roles2EmpService{
    /**
     * 新增员工角色绑定数据
     * @param roles2Emp
     * @return
     */
    Integer insert(Roles2Emp roles2Emp);

}
