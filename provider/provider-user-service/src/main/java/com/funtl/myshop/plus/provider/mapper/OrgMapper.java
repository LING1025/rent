package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.Org;
import com.funtl.myshop.plus.provider.domain.OrgNameList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrgMapper extends MyMapper<Org> {
    List<OrgNameList> selectOrgName(@Param("depName") String depName);

}
