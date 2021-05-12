package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.Orders;
import com.funtl.myshop.plus.provider.domain.ProjectList;
import com.funtl.myshop.plus.provider.dto.ProjectQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {
    /*获取专案明细*/
    List<ProjectList> selectProList(@Param("projectQueryParam") ProjectQueryParam projectQueryParam);
}
