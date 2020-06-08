package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.ReportFormService;
import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParams;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表信息管理
 */

@Api(tags = "报表相关操作")
@RestController
@RequestMapping(value = "table")
public class TableController {
    @Reference(version = "1.0.0")
    private ReportFormService reportFormService;

    @ApiOperation(value = "获取营业报表信息")
    @GetMapping(value = "queryRptQ")
    public ResponseResult<List<ReportForms>> queryRptQ(@RequestParam(name = "type",required = false) Integer type,
                                                       @RequestParam(name = "userID",required = false) Long userID,
                                                       @RequestParam(name = "startDT_F",required = false) String startDT_F,
                                                       @RequestParam(name = "startDT_E",required = false) String startDT_E){
        RptQueryParams rptQueryParams = new RptQueryParams(type,userID,startDT_F,startDT_E);
        List<ReportForms> list = reportFormService.getRptQ(rptQueryParams);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }
}
