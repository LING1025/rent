package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.CusNameList;
import com.funtl.myshop.plus.provider.domain.ItemCode;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface ItemCodeMapper extends MyMapper<ItemCode> {
    /*客户来源名称下拉选*/
    List<CusNameList> selectCusNameList(@Param("customerName") String customerName);
}
