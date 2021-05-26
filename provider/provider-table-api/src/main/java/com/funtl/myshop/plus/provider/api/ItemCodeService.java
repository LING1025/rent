package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CusNameList;
import com.funtl.myshop.plus.provider.domain.ItemCode;

import java.util.List;

public interface ItemCodeService{
    /**
     * 客户来源名称下拉选
     * @param customerName
     * @return
     */
    List<CusNameList> selectCusNameList(String customerName);
}
