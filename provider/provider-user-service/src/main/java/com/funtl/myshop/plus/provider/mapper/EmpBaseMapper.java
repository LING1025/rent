package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.EmpAgentList;
import com.funtl.myshop.plus.provider.domain.EmpBase;
import com.funtl.myshop.plus.provider.domain.EmpList;
import com.funtl.myshop.plus.provider.dto.EmpQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface EmpBaseMapper extends MyMapper<EmpBase> {
    List<EmpList> selectEmpListDto(@Param("param")EmpQueryParam empQueryParam);

    List<EmpAgentList> selectEmpAgent(@Param("fName") String fName);
}
