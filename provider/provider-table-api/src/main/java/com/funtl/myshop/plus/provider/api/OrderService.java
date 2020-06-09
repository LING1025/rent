package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Order;
public interface OrderService{


    int deleteByPrimaryKey(Long orderAuto);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderAuto);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

}
