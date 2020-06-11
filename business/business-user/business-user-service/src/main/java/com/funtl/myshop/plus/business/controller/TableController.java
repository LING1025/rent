package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.Org2EmpService;
import com.funtl.myshop.plus.provider.api.OrgService;
import com.funtl.myshop.plus.provider.api.PerformanceService;
import com.funtl.myshop.plus.provider.domain.Org;
import com.funtl.myshop.plus.provider.domain.Org2Emp;
import com.funtl.myshop.plus.provider.domain.ReportForms;
import com.funtl.myshop.plus.provider.dto.RptQueryParam;
import com.google.common.collect.Lists;
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

    @Reference(version = "1.0.0")
    private Org2EmpService org2EmpService;

    @Reference(version = "1.0.0")
    private OrgService orgService;

    @ApiOperation(value = "获取部门营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path")
           /* @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = true, dataType = "string", paramType = "path")*/
    })
    @GetMapping(value = "query")
    public ResponseResult<List<ReportForms>> query(@RequestParam(name = "year",required = false) Integer year,
                                                       @RequestParam(name = "month",required = false) Integer month
                                                       /*@RequestParam(name = "startDate",required = true) String startDate,
                                                       @RequestParam(name = "endDate",required = true) String endDate*/){
        List<Org2Emp> org2Emps = org2EmpService.selectType(21);
        if(org2Emps.size() > 0){
            List<ReportForms> list = Lists.newArrayList();
            for(Org2Emp oe : org2Emps){
                if(oe != null){
                    RptQueryParam rptQueryParam = new RptQueryParam(year,month,oe.getUserAuto());
                    ReportForms reportForms = performanceService.selectByYM(rptQueryParam);
                    list.add(reportForms);
                }
            }
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"暂无数据",null);
    }

    @ApiOperation(value = "获取课营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryke")
    public ResponseResult<List<ReportForms>> queryke(@RequestParam(name = "year",required = false) Integer year,
                                                   @RequestParam(name = "month",required = false) Integer month){
        List<Org2Emp> org2Emps = org2EmpService.selectType(21);
        if(org2Emps.size() > 0){
            for(Org2Emp org2Emp: org2Emps){
                List<ReportForms> list = performanceService.selectByUpId(year,month,org2Emp.getOrgAuto());
                return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"暂无数据",null);
    }

}
