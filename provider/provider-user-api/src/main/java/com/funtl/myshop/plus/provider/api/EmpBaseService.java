package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.dto.EmpListDto;
import com.funtl.myshop.plus.provider.dto.EmpQueryParam;
import com.github.pagehelper.PageInfo;

public interface EmpBaseService{

    /**
     * 根据员工姓名、部门查询员工信息
     * @param empQueryParam
     * @return
     */
    PageInfo<EmpListDto> selectEmpListDto(EmpQueryParam empQueryParam);

}
