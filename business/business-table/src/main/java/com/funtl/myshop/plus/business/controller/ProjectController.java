package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.domain.CusNameList;
import com.funtl.myshop.plus.provider.domain.ProNameList;
import com.funtl.myshop.plus.provider.domain.ProjectList;
import com.funtl.myshop.plus.provider.dto.ProjectQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "张梦燕所需报表")
@RestController
@RequestMapping(value = "tableFour")
public class ProjectController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    @ApiOperation(value = "专案名称下拉选")
    @ApiImplicitParam(name = "projectName",value = "专案名称",required = true,dataType = "String",paramType = "path")
    @GetMapping(value = "queryProNameList")
    public ResponseResult<List<ProNameList>> queryProNameList(@RequestParam(name = "projectName") String projectName){
        List<ProNameList> lists = ordersService.selectProNameList(projectName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "客户来源名称下拉选")
    @ApiImplicitParam(name = "customerName",value = "客户来源名称",required = true,dataType = "String",paramType = "path")
    @GetMapping(value = "queryCusNameList")
    public ResponseResult<List<CusNameList>> queryCusNameList(@RequestParam(name = "customerName") String customerName){
        List<CusNameList> lists = itemCodeService.selectCusNameList(customerName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "获取专案明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDT",value = "开始时间",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "endDT",value = "结束时间",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "projectName",value = "专案名称",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "customerName",value = "客户来源",required = false,dataType = "String",paramType = "path")
    })
    @GetMapping(value = "queryProList")
    public ResponseResult<List<ProjectList>> queryProList(@RequestParam(name = "startDT",required = false) String startDT,
                                                          @RequestParam(name = "endDT",required = false) String endDT,
                                                          @RequestParam(name = "projectName",required = false) String projectName,
                                                          @RequestParam(name = "customerName",required = false) String customerName) throws ParseException {
        if(startDT == "" || endDT == ""){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：请选择查询区间！！！",null);
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(startDT);
        Date date2 = format.parse(endDT);
        if(date1.after(date2)){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：开始日期必须小于结束日期",null);
        }

        if(projectName == null || projectName == ""){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：请选择专案名称！！！",null);
        }
        ProjectQueryParam projectQueryParam = new ProjectQueryParam(startDT,endDT,projectName,customerName);
        List<ProjectList> lists = ordersService.selectProList(projectQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"查无资料",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }
}
