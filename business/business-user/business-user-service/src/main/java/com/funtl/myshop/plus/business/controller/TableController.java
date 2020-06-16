package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;
import com.funtl.myshop.plus.provider.dto.RptQueryParam;
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
            for(ModeTwoList dto : modeTwoLists){
                List<ReportForms> list1 = performanceService.selectModeZero(year,month,startDate,endDate,dto.getUserAuto());
                return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list1);
            }
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
            for(ModeTwoList dto : modeTwoLists){
                List<ReportForms> list = performanceService.selectModeOne(year,month,startDate,endDate,dto.getOrgAuto());
                return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
            }
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
                ReportForms reportForms = performanceService.selectModeTwo(year,month,startDate,endDate,dto.getUserAuto());
                if(reportForms != null){
                    list.add(reportForms);
                }
            }
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"暂无数据",null);
    }


}
