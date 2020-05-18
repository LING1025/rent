package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.OrgGroup;
import com.funtl.myshop.plus.provider.domain.OrgGroupNameList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrgGroupMapper extends MyMapper<OrgGroup> {
    List<OrgGroupNameList> selectOrgGroupName(@Param("orgGroupName") String orgGroupName);
}
