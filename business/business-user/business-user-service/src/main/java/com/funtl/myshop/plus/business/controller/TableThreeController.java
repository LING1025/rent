package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrderService;
import com.funtl.myshop.plus.provider.domain.YearList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "年度新增呆账&回收报表相关操作")
@RestController
@RequestMapping(value = "tableThree")
public class TableThreeController {
    @Reference(version = "1.0.0")
    private OrderService orderService;

    @ApiOperation(value = "新增呆账&回收")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年度", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "week", value = "周", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryYearList")
    public ResponseResult<List<YearList>> queryYearList(@RequestParam(name = "year") String year,
                                                        @RequestParam(name = "week",defaultValue = "") String week){
        if (year == null || year ==""){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：请输入年份！！",null);
        }
        List<YearList> lists = orderService.selectYearList(year,week);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }
}
