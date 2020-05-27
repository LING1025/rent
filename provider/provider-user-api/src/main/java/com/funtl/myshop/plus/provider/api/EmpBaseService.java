package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.EmpAgentList;
import com.funtl.myshop.plus.provider.domain.EmpBase;
import com.funtl.myshop.plus.provider.dto.EmpListDto;
import com.funtl.myshop.plus.provider.dto.EmpQueryParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmpBaseService{

    /**
     * 根据员工姓名、部门查询员工信息
     * @param empQueryParam
     * @return
     */
    PageInfo<EmpListDto> selectEmpListDto(EmpQueryParam empQueryParam);

    /**
     * 新增员工信息
     * @param empBase
     * @return
     */
    Long insert(EmpBase empBase);

    /**
     * 根据主键删除员工数据
     * @param empBaseAuto
     * @return
     */
    Integer deleteById(Long empBaseAuto);

    /**
     * 修改员工数据
     * @param empBase
     * @return
     */
    Integer update(EmpBase empBase);

    /**
     * 根据主键获取员工数据
     * @param empBaseAuto
     * @return
     */
    EmpBase selectById(Long empBaseAuto);

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    EmpBase selectUsername(String username);

    /**
     * 根据员工姓名获取员工信息
     * @param fName
     * @return
     */
    List<EmpBase> selectByfName(String fName);

    /**
     * 根据员工姓名获取员工代理信息
     * @param fName
     * @return
     */
    List<EmpAgentList> selectEmpAgent(String fName);

}
