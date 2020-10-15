package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CompanyNameList;

import java.util.List;

public interface IncService{

    /**
     * 公司别绑定
     * @param mode
     * @param searchWord
     * @return
     */
    List<CompanyNameList> selectCompanyName(Integer mode,String searchWord);

}
