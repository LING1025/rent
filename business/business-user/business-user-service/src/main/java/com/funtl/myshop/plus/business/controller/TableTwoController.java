package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrderService;
import com.funtl.myshop.plus.provider.domain.CaseProList;
import com.funtl.myshop.plus.provider.dto.CaseProQueryParam;
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

@Api(tags = "大陆出行事业业绩周报表相关操作")
@RestController
@RequestMapping(value = "tableTwo")
public class TableTwoController {
    @Reference(version = "1.0.0")
    private OrderService orderService;

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
}
