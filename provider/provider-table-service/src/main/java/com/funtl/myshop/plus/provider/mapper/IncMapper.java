package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.CompanyNameList;
import com.funtl.myshop.plus.provider.domain.Inc;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface IncMapper extends MyMapper<Inc> {
    List<CompanyNameList> selectCompanyName(@Param("mode") Integer mode, @Param("searchWord") String searchWord);
}
