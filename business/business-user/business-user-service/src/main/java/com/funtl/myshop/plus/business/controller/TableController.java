package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;
import com.funtl.myshop.plus.provider.dto.RptQueryParam;
import com.funtl.myshop.plus.provider.dto.RptQueryParams;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
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

    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    @Reference(version = "1.0.0")
    private VEmpService vEmpService;

    @ApiOperation(value = "获取营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "用户id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "orgUpAuto", value = "上级部门id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryMode")
    public ResponseResult<List<ReportForms>> queryMode(@RequestParam(name = "userAuto",required = false) Long userAuto,
                                                       @RequestParam(name = "startDate",required = false) String startDate,
                                                       @RequestParam(name = "endDate",required = false) String endDate,
                                                       @RequestParam(name = "orgAuto",defaultValue = "0") Long orgAuto,
                                                       @RequestParam(name = "orgUpAuto",defaultValue = "0") Long orgUpAuto){
        LineChartQueryParam lineChartQueryParam = new LineChartQueryParam(userAuto,startDate,endDate,orgAuto,orgUpAuto);
        List<ReportForms> list = vEmpService.selectMode(lineChartQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

    @ApiOperation(value = "获取业代营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryZero")
    public ResponseResult<List<ReportForms>> queryZero(@RequestParam(name = "year",required = false) Integer year,
                                                      @RequestParam(name = "month",required = false) Integer month,
                                                      @RequestParam(name = "startDate",required = false) String startDate,
                                                      @RequestParam(name = "endDate",required = false) String endDate){
        //获取上级部门，reportFroms查询时条件改成emp.upUnit = org.orgAuto,获取该部门下的课的业代
        List<ModeTwoList> modeTwoLists = orgService.selectModeTwo(1,4);
        if(modeTwoLists.size() > 0){
            List<Long> orgIds = Lists.newArrayList();
            for(ModeTwoList dto : modeTwoLists){
                orgIds.add(dto.getOrgAuto());
            }
            RptQueryParam rptQueryParam = new RptQueryParam(year,month,startDate,endDate,orgIds);
            List<ReportForms> list1 = performanceService.selectModeZeros(rptQueryParam);
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list1);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"暂无数据",null);
    }

    @ApiOperation(value = "获取课营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryOne")
    public ResponseResult<List<ReportForms>> queryOne(@RequestParam(name = "year",required = false) Integer year,
                                                     @RequestParam(name = "month",required = false) Integer month,
                                                    @RequestParam(name = "startDate",required = false) String startDate,
                                                    @RequestParam(name = "endDate",required = false) String endDate){
        /*List<ModeTwoList> modeTwoLists = orgService.selectModeOne(1,5,0);
        if(modeTwoLists.size() > 0){
            List<ReportForms> list = Lists.newArrayList();
            for(ModeTwoList dto : modeTwoLists){
                ReportForms reportForms = performanceService.selectModeTwo(year,month,startDate,endDate,dto.getUserAuto());
                if(reportForms != null){
                    list.add(reportForms);
                }
            }
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
        }*/

        //获取上级部门，reportFroms查询时条件改成emp.upUnit = org.orgAuto,获取该部门下的课
        List<ModeTwoList> modeTwoLists = orgService.selectModeTwo(1,4);
        if(modeTwoLists.size() > 0){
            List<Long> orgIds = Lists.newArrayList();
            for(ModeTwoList dto : modeTwoLists){
                orgIds.add(dto.getOrgAuto());
            }
//            List<ReportForms> list = performanceService.selectModeOne(year,month,startDate,endDate,dto.getOrgAuto());
            RptQueryParam rptQueryParam = new RptQueryParam(year,month,startDate,endDate,orgIds);
            List<ReportForms> list = performanceService.selectModeOnes(rptQueryParam);
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"暂无数据",null);
    }

    @ApiOperation(value = "获取部门营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryTwo")
    public ResponseResult<List<ReportForms>> queryTwo(@RequestParam(name = "year",required = false) Integer year,
                                                      @RequestParam(name = "month",required = false) Integer month,
                                                      @RequestParam(name = "startDate",required = false) String startDate,
                                                      @RequestParam(name = "endDate",required = false) String endDate){
        List<ModeTwoList> modeTwoLists = orgService.selectModeTwo(1,4);
        if(modeTwoLists.size() > 0){
            List<ReportForms> list = Lists.newArrayList();
            for(ModeTwoList dto : modeTwoLists){
                RptQueryParams rptQueryParams = new RptQueryParams(year,month,startDate,endDate,dto.getOrgAuto());
                ReportForms reportForms = performanceService.selectModeTwo(rptQueryParams);
                if(reportForms != null){
                    list.add(reportForms);
                }
            }
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"暂无数据",null);
    }


}
