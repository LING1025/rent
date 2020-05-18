package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.IncTitle;
public interface IncTitleService{
    /**
     * 根据职位id获取职位信息
     * @param incTitleAuto
     * @return
     */
    IncTitle selectById(Integer incTitleAuto);

}
