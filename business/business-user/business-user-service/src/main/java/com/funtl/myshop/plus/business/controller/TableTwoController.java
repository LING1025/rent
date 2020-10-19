package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.IncService;
import com.funtl.myshop.plus.provider.api.OrderService;
import com.funtl.myshop.plus.provider.domain.CaseExecList;
import com.funtl.myshop.plus.provider.domain.CaseProList;
import com.funtl.myshop.plus.provider.domain.CompanyNameList;
import com.funtl.myshop.plus.provider.domain.ThisMonthTar;
import com.funtl.myshop.plus.provider.dto.CaseProQueryParam;
import com.funtl.myshop.plus.provider.dto.LineChartQueryParam;
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

import java.text.ParseException;
import java.util.List;

@Api(tags = "大陆出行事业业绩周报表相关操作")
@RestController
@RequestMapping(value = "tableTwo")
public class TableTwoController {
    @Reference(version = "1.0.0")
    private OrderService orderService;

    @Reference(version = "1.0.0")
    private IncService incService;

    @ApiOperation(value = "公司别绑定下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mode", value = "查询类别：0全部 1公司别所有信息 2依据Inc_Auto 3以TradeItem_Auto 4以公司名称查询", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "searchWord", value = "查询条件", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryCompanyNameList")
    public ResponseResult<List<CompanyNameList>> queryCompanyNameList(@RequestParam(name = "mode", defaultValue = "0") Integer mode,
                                                                      @RequestParam(name = "searchWord", defaultValue = "")String searchWord){
        List<CompanyNameList> list = incService.selectCompanyNameList(mode,searchWord);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

    @ApiOperation(value = "案件进度维护查询按钮")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inc", value = "公司别", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "type", value = "查询类别", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "flag", value = "单选按钮", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "customer", value = "客户名称", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryCaseProList")
    public ResponseResult<List<CaseProList>> queryCaseProList(@RequestParam(name = "inc",required = false) Integer inc,
                                                              @RequestParam(name = "type",required = false) Integer type,
                                                              @RequestParam(name = "year",required = false) Integer year,
                                                              @RequestParam(name = "month",required = false) Integer month,
                                                              @RequestParam(name = "flag",required = false) Integer flag,
                                                              @RequestParam(name = "customer", defaultValue = "") String customer) throws ParseException {
        CaseProQueryParam caseProQueryParam = new CaseProQueryParam(inc,type,year,month,flag,customer);
        List<CaseProList> caseProLists = orderService.selectCaseProList(caseProQueryParam);
        if (caseProLists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"无数据",caseProLists);
        }
        for (CaseProList caseProList : caseProLists){
            if (caseProList.getBonusStatus() != null && !caseProList.getBonusStatus().equals("") && caseProList.getBonusStatus() != 0 ){
                caseProList.setChkBonusStatus(1);
            }else {
                caseProList.setChkBonusStatus(0);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",caseProLists);
    }

    @ApiOperation(value = "案件维护汇出表格数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inc", value = "公司别", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "type", value = "查询类别", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "flag", value = "单选按钮", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "customer", value = "客户名称", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryCaseExecList")
    public ResponseResult<List<CaseExecList>> queryCaseExecList(@RequestParam(name = "inc",required = false) Integer inc,
                                                                @RequestParam(name = "type",required = false) Integer type,
                                                                @RequestParam(name = "year",required = false) Integer year,
                                                                @RequestParam(name = "month",required = false) Integer month,
                                                                @RequestParam(name = "flag",required = false) Integer flag,
                                                                @RequestParam(name = "customer", defaultValue = "") String customer) throws ParseException {
        CaseProQueryParam caseProQueryParam = new CaseProQueryParam(inc,type,year,month,flag,customer);
        List<CaseExecList> lists = orderService.selectCaseExecList(caseProQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"无数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }


    @ApiOperation(value = "获取业绩周报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "用户id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "orgUpAuto", value = "上级部门id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryThisMonthTar")
    public ResponseResult<List<ThisMonthTar>> queryThisMonthTar(@RequestParam(name = "userAuto",required = false) Long userAuto,
                                                          @RequestParam(name = "startDate",required = false) String startDate,
                                                          @RequestParam(name = "endDate",required = false) String endDate,
                                                          @RequestParam(name = "orgAuto",defaultValue = "0") Long orgAuto,
                                                          @RequestParam(name = "orgUpAuto",defaultValue = "0") Long orgUpAuto){
        List<ThisMonthTar> list = Lists.newArrayList();//todo：将查到的数据插入列表中
        //当月目标
        LineChartQueryParam lineChartQueryParam = new LineChartQueryParam(userAuto,startDate,endDate,orgAuto,orgUpAuto);
        ThisMonthTar thisMonthTar = orderService.selectThisMonGoal(lineChartQueryParam);
        //当月实绩 todo：开始时间结束时间截取
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }
}
