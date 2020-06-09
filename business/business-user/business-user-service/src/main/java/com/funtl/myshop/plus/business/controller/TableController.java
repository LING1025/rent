package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.PerformanceService;
import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParam;
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

/**
 * 报表信息管理
 */

@Api(tags = "报表相关操作")
@RestController
@RequestMapping(value = "table")
public class TableController {
    @Reference(version = "1.0.0")
    private PerformanceService performanceService;

    @ApiOperation(value = "获取营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = true, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "query")
    public ResponseResult<List<ReportForms>> query(@RequestParam(name = "year",required = true) Integer year,
                                                       @RequestParam(name = "month",required = true) Integer month,
                                                       @RequestParam(name = "startDate",required = true) String startDate,
                                                       @RequestParam(name = "endDate",required = true) String endDate){
        RptQueryParam rptQueryParam = new RptQueryParam(year,month,startDate,endDate);
        List<ReportForms> list = performanceService.selectByYM(rptQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

}
