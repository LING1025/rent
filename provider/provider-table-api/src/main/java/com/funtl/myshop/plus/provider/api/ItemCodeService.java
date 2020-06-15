package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ItemCode;

import java.util.List;

public interface ItemCodeService{

    /**
     * 根据年份获取目标营业额
     * @param year
     * @return
     */
    List<ItemCode> selectByYear(Integer year);
}
