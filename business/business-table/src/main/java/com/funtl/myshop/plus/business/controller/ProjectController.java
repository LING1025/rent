package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrdersService;
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

import java.util.List;

@Api(tags = "张梦燕所需报表")
@RestController
@RequestMapping(value = "tableFour")
public class ProjectController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @ApiOperation(value = "获取专案明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDT",value = "开始时间",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "endDT",value = "结束时间",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "projectName",value = "专案名称",required = true,dataType = "String",paramType = "path")
    })
    @GetMapping(value = "queryProList")
    public ResponseResult<List<ProjectList>> queryProList(@RequestParam(name = "startDT") String startDT,
                                                          @RequestParam(name = "endDT") String endDT,
                                                          @RequestParam(name = "projectName") String projectName){
        ProjectQueryParam projectQueryParam = new ProjectQueryParam(startDT,endDT,projectName);
        List<ProjectList> lists = ordersService.selectProList(projectQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }
}
