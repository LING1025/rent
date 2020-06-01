package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Roles2Emp;

import java.util.List;

public interface Roles2EmpService{
    /**
     * 新增员工角色绑定数据
     * @param roles2Emp
     * @return
     */
    Long insert(Roles2Emp roles2Emp);

    /**
     * 根据主键删除员工角色绑定数据
     * @param roles2EmpAuto
     * @return
     */
    Integer deleteById(Long roles2EmpAuto);

    /**
     * 根据员工id删除员工角色绑定数据
     * @param empBaseAuto
     * @return
     */
    Integer deleteByEmpAuto(Long empBaseAuto);

}
