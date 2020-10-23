package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.IncService;
import com.funtl.myshop.plus.provider.api.OrderService;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
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

import java.math.BigDecimal;
import java.text.NumberFormat;
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

    @ApiOperation(value = "新增契约租金-客户来源")
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
                                                          @RequestParam(name = "orgUpAuto",defaultValue = "0") Long orgUpAuto) throws ParseException {
        if(startDate == null || endDate == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：查询日期不能为空",null);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(startDate);
        Date date2 = format.parse(endDate);
        if(date1.after(date2)){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：开始日期必须小于结束日期",null);
        }
        String startYear = startDate.split("-")[0];
        String endYear = endDate.split("-")[0];
        String startMon = startDate.split("-")[1];
        String endMon = endDate.split("-")[1];
        if (!startYear.equals(endYear) || !startMon.equals(endMon)) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：不允许跨年份或月份查询",null);
        }
        List<ThisMonthTar> list = Lists.newArrayList();

        //当月目标
        LineChartQueryParam lineChartQueryParam = new LineChartQueryParam(userAuto,startDate,endDate,orgAuto,orgUpAuto);
        ThisMonthTar thisMonthTar1 = orderService.selectThisMonGoal(lineChartQueryParam);
        thisMonthTar1.setNewExsNew(thisMonthTar1.getNewExs().toString());
        thisMonthTar1.setRetainNew(thisMonthTar1.getRetain().toString());
        thisMonthTar1.setIntroduceNew(thisMonthTar1.getIntroduce().toString());
        thisMonthTar1.setTotalNew(thisMonthTar1.getTotalNumAmt().toString());
        thisMonthTar1.setTableName("当月目标");
        list.add(thisMonthTar1);


        //当月实绩
        MonGoalQueryParam monGoalQueryParam = new MonGoalQueryParam(0,4,startYear,startMon,1,"",startDate,endDate,3);
        ThisMonthTar thisMonthTar2 = orderService.selectThisMonReal(monGoalQueryParam);
        thisMonthTar2.setNewExsNew(thisMonthTar2.getNewExs().toString());
        thisMonthTar2.setRetainNew(thisMonthTar2.getRetain().toString());
        thisMonthTar2.setIntroduceNew(thisMonthTar2.getIntroduce().toString());
        thisMonthTar2.setTotalNew(thisMonthTar2.getTotalNumAmt().toString());
        thisMonthTar2.setTableName("当月实绩");
        list.add(thisMonthTar2);

        NumberFormat nt = NumberFormat.getPercentInstance();//getPercentInstance()百分比

        //结构比
        ThisMonthTar thisMonthTar3 = new ThisMonthTar();
        thisMonthTar3.setTableName("结构比");
        thisMonthTar3.setTotalNumAmt(thisMonthTar2.getTotalNumAmt().divide(thisMonthTar2.getTotalNumAmt()));
        thisMonthTar3.setTotalNew(nt.format(thisMonthTar3.getTotalNumAmt()));
        thisMonthTar3.setNewExs(thisMonthTar2.getNewExs().divide(thisMonthTar2.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));//四舍五入保留两位小数
        thisMonthTar3.setNewExsNew(nt.format(thisMonthTar3.getNewExs()));
        thisMonthTar3.setRetain(thisMonthTar2.getRetain().divide(thisMonthTar2.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        thisMonthTar3.setRetainNew(nt.format(thisMonthTar3.getRetain()));
        thisMonthTar3.setIntroduce(thisMonthTar2.getIntroduce().divide(thisMonthTar2.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        thisMonthTar3.setIntroduceNew(nt.format(thisMonthTar3.getIntroduce()));
        list.add(thisMonthTar3);

        //达成率
        ThisMonthTar thisMonthTar4 = new ThisMonthTar();
        thisMonthTar4.setTableName("达成率");
        thisMonthTar4.setTotalNumAmt(thisMonthTar2.getTotalNumAmt().divide(thisMonthTar1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        thisMonthTar4.setTotalNew(nt.format(thisMonthTar4.getTotalNumAmt()));
        thisMonthTar4.setNewExs(thisMonthTar2.getNewExs().divide(thisMonthTar1.getNewExs(), 2, BigDecimal.ROUND_HALF_UP));
        thisMonthTar4.setNewExsNew(nt.format(thisMonthTar4.getNewExs()));
        thisMonthTar4.setRetain(thisMonthTar2.getRetain().divide(thisMonthTar1.getRetain(), 2, BigDecimal.ROUND_HALF_UP));
        thisMonthTar4.setRetainNew(nt.format(thisMonthTar4.getRetain()));
        thisMonthTar4.setIntroduce(thisMonthTar2.getIntroduce().divide(thisMonthTar1.getIntroduce(), 2, BigDecimal.ROUND_HALF_UP));
        thisMonthTar4.setIntroduceNew(nt.format(thisMonthTar4.getIntroduce()));
        list.add(thisMonthTar4);

        //上月实绩
        Integer lastY = Integer.valueOf(startYear);
        Integer lastM = Integer.valueOf(startMon) - 1;
        if (lastM == 0){
            lastM = 12;
            lastY = Integer.valueOf(startYear) - 1;
        }
        String lastStartMon = lastM.toString();
        String lastStartYear = lastY.toString();
        String lastStartDate = lastStartYear + "-" +lastStartMon + "-" + startDate.split("-")[2];
        String lastEndDate = lastStartYear + "-" + lastStartMon + "-" + endDate.split("-")[2];

        MonGoalQueryParam monGoalQueryParam2 = new MonGoalQueryParam(0,4,lastStartYear,lastStartMon,1,"",lastStartDate,lastEndDate,3);
        ThisMonthTar thisMonthTar5 = orderService.selectThisMonReal(monGoalQueryParam2);
        thisMonthTar5.setTableName("上月实绩");
        thisMonthTar5.setTotalNew(thisMonthTar5.getTotalNumAmt().toString());
        thisMonthTar5.setNewExsNew(thisMonthTar5.getNewExs().toString());
        thisMonthTar5.setRetainNew(thisMonthTar5.getRetain().toString());
        thisMonthTar5.setIntroduceNew(thisMonthTar5.getIntroduce().toString());
        list.add(thisMonthTar5);

        //环比
        ThisMonthTar thisMonthTar6 = new ThisMonthTar();
        thisMonthTar6.setTableName("环比");
        thisMonthTar6.setTotalNumAmt(thisMonthTar2.getTotalNumAmt().divide(thisMonthTar5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
        thisMonthTar6.setTotalNew(nt.format(thisMonthTar6.getTotalNumAmt()));
        if (thisMonthTar5.getNewExs().equals("0.00")){
            thisMonthTar6.setNewExsNew("-");
        }else {
            thisMonthTar6.setNewExs(thisMonthTar2.getNewExs().divide(thisMonthTar5.getNewExs(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            thisMonthTar6.setNewExsNew(nt.format(thisMonthTar6.getNewExs()));
        }

        if (thisMonthTar5.getRetain().equals("0.00")){
            thisMonthTar6.setRetainNew("-");
        }else {
            thisMonthTar6.setRetain(thisMonthTar2.getRetain().divide(thisMonthTar5.getRetain(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            thisMonthTar6.setRetainNew(nt.format(thisMonthTar6.getRetain()));
        }

        if(thisMonthTar5.getIntroduceNew().equals("0.00")){
            thisMonthTar6.setIntroduceNew("-");
        }else {
            thisMonthTar6.setIntroduce(thisMonthTar2.getIntroduce().divide(thisMonthTar5.getIntroduce(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            thisMonthTar6.setIntroduceNew(nt.format(thisMonthTar6.getIntroduce()));
        }
        list.add(thisMonthTar6);

        //去年实绩
        Integer lYear = Integer.valueOf(startYear) - 1;
        String lastYear = lYear.toString();
        String lastSD = lastYear + "-" + startMon + "-" + startDate.split("-")[2];
        String lastED = lastYear + "-" + endMon + "-" + endDate.split("-")[2];
        MonGoalQueryParam monGoalQueryParam3 = new MonGoalQueryParam(0,4,lastYear,startMon,1,"",lastSD,lastED,3);
        ThisMonthTar thisMonthTar7 = orderService.selectThisMonReal(monGoalQueryParam3);
        thisMonthTar7.setTableName("去年实绩");
        thisMonthTar7.setTotalNew(thisMonthTar7.getTotalNumAmt().toString());
        thisMonthTar7.setNewExsNew(thisMonthTar7.getNewExs().toString());
        thisMonthTar7.setRetainNew(thisMonthTar7.getRetain().toString());
        thisMonthTar7.setIntroduceNew(thisMonthTar7.getIntroduce().toString());
        list.add(thisMonthTar7);

        //结构比
        ThisMonthTar thisMonthTar8 = new ThisMonthTar();
        thisMonthTar8.setTableName("结构比");
        thisMonthTar8.setTotalNumAmt(thisMonthTar7.getTotalNumAmt().divide(thisMonthTar7.getTotalNumAmt()));
        thisMonthTar8.setTotalNew(nt.format(thisMonthTar8.getTotalNumAmt()));
        thisMonthTar8.setNewExs(thisMonthTar7.getNewExs().divide(thisMonthTar7.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));//四舍五入保留两位小数
        thisMonthTar8.setNewExsNew(nt.format(thisMonthTar8.getNewExs()));
        thisMonthTar8.setRetain(thisMonthTar7.getRetain().divide(thisMonthTar7.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        thisMonthTar8.setRetainNew(nt.format(thisMonthTar8.getRetain()));
        thisMonthTar8.setIntroduce(thisMonthTar7.getIntroduce().divide(thisMonthTar7.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        thisMonthTar8.setIntroduceNew(nt.format(thisMonthTar8.getIntroduce()));
        list.add(thisMonthTar8);

        //同期对比
        ThisMonthTar thisMonthTar9 = new ThisMonthTar();
        thisMonthTar9.setTableName("同期比较");
        thisMonthTar9.setTotalNumAmt(thisMonthTar2.getTotalNumAmt().divide(thisMonthTar7.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
        thisMonthTar9.setTotalNew(nt.format(thisMonthTar9.getTotalNumAmt()));
        if (thisMonthTar7.getNewExs().equals("0.00")){
            thisMonthTar9.setNewExsNew("-");
        }else {
            thisMonthTar9.setNewExs(thisMonthTar2.getNewExs().divide(thisMonthTar7.getNewExs(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            thisMonthTar9.setNewExsNew(nt.format(thisMonthTar9.getNewExs()));
        }

        if (thisMonthTar7.getRetain().equals("0.00")){
            thisMonthTar9.setRetainNew("-");
        }else {
            thisMonthTar9.setRetain(thisMonthTar2.getRetain().divide(thisMonthTar7.getRetain(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            thisMonthTar9.setRetainNew(nt.format(thisMonthTar9.getRetain()));
        }

        if(thisMonthTar7.getIntroduceNew().equals("0.00")){
            thisMonthTar9.setIntroduceNew("-");
        }else {
            thisMonthTar9.setIntroduce(thisMonthTar2.getIntroduce().divide(thisMonthTar7.getIntroduce(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            thisMonthTar9.setIntroduceNew(nt.format(thisMonthTar9.getIntroduce()));
        }
        list.add(thisMonthTar9);

        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

    @ApiOperation(value = "新增契约租金,台数-车辆来源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryCarSourceRent")
    public ResponseResult<List<CarSourceRent>> queryCarSourceRent(@RequestParam(name = "startDate",required = false) String startDate,
                                                                 @RequestParam(name = "endDate",required = false) String endDate,
                                                                  @RequestParam(name = "typeQuery",required = false) Integer typeQuery) throws ParseException {

        if(startDate == null || endDate == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：查询日期不能为空",null);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(startDate);
        Date date2 = format.parse(endDate);
        if(date1.after(date2)){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：开始日期必须小于结束日期",null);
        }
        String startYear = startDate.split("-")[0];
        String endYear = endDate.split("-")[0];
        String startMon = startDate.split("-")[1];
        String endMon = endDate.split("-")[1];
        if (!startYear.equals(endYear) || !startMon.equals(endMon)) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：不允许跨年份或月份查询",null);
        }
        List<CarSourceRent> list = Lists.newArrayList();

        //当月实绩
        MonGoalQueryParam monGoalQueryParam = new MonGoalQueryParam(0,4,startYear,startMon,1,"",startDate,endDate,typeQuery);
        CarSourceRent carSourceRent1 = orderService.selectCarSourceRent(monGoalQueryParam);
        carSourceRent1.setTableTwoName("当月实绩");
        if (carSourceRent1.getEastNewCar() == null){
            carSourceRent1.setEastNewCarN(String.valueOf(0));
        }else{
            carSourceRent1.setEastNewCarN(carSourceRent1.getEastNewCar().toString());
        }

        if (carSourceRent1.getEastOldCar() == null){
            carSourceRent1.setEastOldCarN(String.valueOf(0));
        }else{
            carSourceRent1.setEastOldCarN(carSourceRent1.getEastOldCar().toString());
        }

        if (carSourceRent1.getSouthNewCar() == null){
            carSourceRent1.setSouthNewCarN(String.valueOf(0));
        }else{
            carSourceRent1.setSouthNewCarN(carSourceRent1.getSouthNewCar().toString());
        }

        if (carSourceRent1.getSouthOldCar() == null){
            carSourceRent1.setSouthOldCarN(String.valueOf(0));
        }else{
            carSourceRent1.setSouthOldCarN(carSourceRent1.getSouthOldCar().toString());
        }

        if (carSourceRent1.getTotalNumAmt() == null){
            carSourceRent1.setTotalNumAmtN(String.valueOf(0));
        }else{
            carSourceRent1.setTotalNumAmtN(carSourceRent1.getTotalNumAmt().toString());
        }

        list.add(carSourceRent1);

        NumberFormat nt = NumberFormat.getPercentInstance();//getPercentInstance()百分比

        //结构比
        CarSourceRent carSourceRent2 = new CarSourceRent();
        carSourceRent2.setTableTwoName("结构比");
        carSourceRent2.setTotalNumAmtN("100%");
        carSourceRent2.setEastNewCar(carSourceRent1.getEastNewCar().divide(carSourceRent1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent2.setEastNewCarN(nt.format(carSourceRent2.getEastNewCar()));
        carSourceRent2.setEastOldCar(carSourceRent1.getEastOldCar().divide(carSourceRent1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent2.setEastOldCarN(nt.format(carSourceRent2.getEastOldCar()));
        carSourceRent2.setSouthNewCar(carSourceRent1.getSouthNewCar().divide(carSourceRent1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent2.setSouthNewCarN(nt.format(carSourceRent2.getSouthNewCar()));
        carSourceRent2.setSouthOldCar(carSourceRent1.getSouthOldCar().divide(carSourceRent1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent2.setSouthOldCarN(nt.format(carSourceRent2.getSouthOldCar()));
        list.add(carSourceRent2);

        //上月实绩
        Integer lastY = Integer.valueOf(startYear);
        Integer lastM = Integer.valueOf(startMon) - 1;
        if (lastM == 0){
            lastM = 12;
            lastY = Integer.valueOf(startYear) - 1;
        }
        String lastStartMon = lastM.toString();
        String lastStartYear = lastY.toString();
        String lastStartDate = lastStartYear + "-" +lastStartMon + "-" + startDate.split("-")[2];
        String lastEndDate = lastStartYear + "-" + lastStartMon + "-" + endDate.split("-")[2];

        MonGoalQueryParam monGoalQueryParam2 = new MonGoalQueryParam(0,4,lastStartYear,lastStartMon,1,"",lastStartDate,lastEndDate,typeQuery);
        CarSourceRent carSourceRent3 = orderService.selectCarSourceRent(monGoalQueryParam2);
        carSourceRent3.setTableTwoName("上月实绩");
        carSourceRent3.setEastNewCarN(carSourceRent3.getEastNewCar().toString());
        carSourceRent3.setEastOldCarN(carSourceRent3.getEastOldCar().toString());
        carSourceRent3.setSouthNewCarN(carSourceRent3.getSouthNewCar().toString());
        carSourceRent3.setSouthOldCarN(carSourceRent3.getSouthOldCar().toString());
        carSourceRent3.setTotalNumAmtN(carSourceRent3.getTotalNumAmt().toString());
        list.add(carSourceRent3);

        //环比
        CarSourceRent carSourceRent4 = new CarSourceRent();
        carSourceRent4.setTableTwoName("环比");

        if (carSourceRent3.getEastNewCarN().equals("0.00")){
            carSourceRent4.setEastNewCarN("-");
        }else {
            carSourceRent4.setEastNewCar(carSourceRent1.getEastNewCar().divide(carSourceRent3.getEastNewCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            carSourceRent4.setEastNewCarN(nt.format(carSourceRent4.getEastNewCar()));
        }

        if (carSourceRent3.getEastOldCarN().equals("0.00")){
            carSourceRent4.setEastOldCarN("-");
        }else {
            carSourceRent4.setEastOldCar(carSourceRent1.getEastOldCar().divide(carSourceRent3.getEastOldCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            carSourceRent4.setEastOldCarN(nt.format(carSourceRent4.getEastOldCar()));
        }

        if (carSourceRent3.getSouthNewCarN().equals("0.00")){
            carSourceRent4.setSouthNewCarN("-");
        }else {
            carSourceRent4.setSouthNewCar(carSourceRent1.getSouthNewCar().divide(carSourceRent3.getSouthNewCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            carSourceRent4.setSouthNewCarN(nt.format(carSourceRent4.getSouthNewCar()));
        }

        if (carSourceRent3.getSouthOldCarN().equals("0.00")){
            carSourceRent4.setSouthOldCarN("-");
        }else {
            carSourceRent4.setSouthOldCar(carSourceRent1.getSouthOldCar().divide(carSourceRent3.getSouthOldCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            carSourceRent4.setSouthOldCarN(nt.format(carSourceRent4.getSouthOldCar()));
        }

        carSourceRent4.setTotalNumAmt(carSourceRent1.getTotalNumAmt().divide(carSourceRent3.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
        carSourceRent4.setTotalNumAmtN(nt.format(carSourceRent4.getTotalNumAmt()));
        list.add(carSourceRent4);

        //去年实绩
        Integer lYear = Integer.valueOf(startYear) - 1;
        String lastYear = lYear.toString();
        String lastSD = lastYear + "-" + startMon + "-" + startDate.split("-")[2];
        String lastED = lastYear + "-" + endMon + "-" + endDate.split("-")[2];
        MonGoalQueryParam monGoalQueryParam3 = new MonGoalQueryParam(0,4,lastYear,startMon,1,"",lastSD,lastED,typeQuery);
        CarSourceRent carSourceRent5 = orderService.selectCarSourceRent(monGoalQueryParam3);
        carSourceRent5.setTableTwoName("去年实绩");
        carSourceRent5.setEastNewCarN(carSourceRent5.getEastNewCar().toString());
        carSourceRent5.setEastOldCarN(carSourceRent5.getEastOldCar().toString());
        carSourceRent5.setSouthNewCarN(carSourceRent5.getSouthNewCar().toString());
        carSourceRent5.setSouthOldCarN(carSourceRent5.getSouthOldCar().toString());
        carSourceRent5.setTotalNumAmtN(carSourceRent5.getTotalNumAmt().toString());
        list.add(carSourceRent5);

        //结构比
        CarSourceRent carSourceRent6 = new CarSourceRent();
        carSourceRent6.setTableTwoName("结构比");
        carSourceRent6.setTotalNumAmt(carSourceRent5.getTotalNumAmt().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent6.setTotalNumAmtN(nt.format(carSourceRent6.getTotalNumAmt()));
        carSourceRent6.setEastNewCar(carSourceRent5.getEastNewCar().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent6.setEastNewCarN(nt.format(carSourceRent6.getEastNewCar()));
        carSourceRent6.setEastOldCar(carSourceRent5.getEastOldCar().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent6.setEastOldCarN(nt.format(carSourceRent6.getEastOldCar()));
        carSourceRent6.setSouthNewCar(carSourceRent5.getSouthNewCar().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent6.setSouthNewCarN(nt.format(carSourceRent6.getSouthNewCar()));
        carSourceRent6.setSouthOldCar(carSourceRent5.getSouthOldCar().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP));
        carSourceRent6.setSouthOldCarN(nt.format(carSourceRent6.getSouthOldCar()));
        list.add(carSourceRent6);

        //同期比较
        CarSourceRent carSourceRent7 = new CarSourceRent();
        carSourceRent7.setTableTwoName("同期比较");

        if (carSourceRent5.getEastNewCarN().equals("0.00")){
            carSourceRent7.setEastNewCarN("-");
        }else {
            carSourceRent7.setEastNewCar(carSourceRent1.getEastNewCar().divide(carSourceRent5.getEastNewCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            carSourceRent7.setEastNewCarN(nt.format(carSourceRent7.getEastNewCar()));
        }

        if (carSourceRent5.getEastOldCarN().equals("0.00")){
            carSourceRent7.setEastOldCarN("-");
        }else {
            carSourceRent7.setEastOldCar(carSourceRent1.getEastOldCar().divide(carSourceRent5.getEastOldCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            carSourceRent7.setEastOldCarN(nt.format(carSourceRent7.getEastOldCar()));
        }

        if (carSourceRent5.getSouthNewCarN().equals("0.00")){
            carSourceRent7.setSouthNewCarN("-");
        }else {
            carSourceRent7.setSouthNewCar(carSourceRent1.getSouthNewCar().divide(carSourceRent5.getSouthNewCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            carSourceRent7.setSouthNewCarN(nt.format(carSourceRent7.getSouthNewCar()));
        }

        if (carSourceRent5.getSouthOldCarN().equals("0.00")){
            carSourceRent7.setSouthOldCarN("-");
        }else {
            carSourceRent7.setSouthOldCar(carSourceRent1.getSouthOldCar().divide(carSourceRent5.getSouthOldCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
            carSourceRent7.setSouthOldCarN(nt.format(carSourceRent7.getSouthOldCar()));
        }

        carSourceRent7.setTotalNumAmt(carSourceRent1.getTotalNumAmt().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1)));
        carSourceRent7.setTotalNumAmtN(nt.format(carSourceRent7.getTotalNumAmt()));
        list.add(carSourceRent7);

        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

    @ApiOperation(value = "保有客户台数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryCustomerNum")
    public ResponseResult<List<CustomerNum>> queryCustomerNum(@RequestParam(name = "startDate",required = false) String startDate,
                                                                  @RequestParam(name = "endDate",required = false) String endDate) throws ParseException {
        if(startDate == null || endDate == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：查询日期不能为空",null);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(startDate);
        Date date2 = format.parse(endDate);
        if(date1.after(date2)){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：开始日期必须小于结束日期",null);
        }
        String startYear = startDate.split("-")[0];
        String endYear = endDate.split("-")[0];
        String startMon = startDate.split("-")[1];
        String endMon = endDate.split("-")[1];
        if (!startYear.equals(endYear) || !startMon.equals(endMon)) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：不允许跨年份或月份查询",null);
        }
        List<CustomerNum> list = Lists.newArrayList();
        CusQueryParam cusQueryParam = new CusQueryParam(7,Integer.valueOf(startYear),Integer.valueOf(startMon),0,0,0,0,startDate,endDate);
        CustomerNum customerNum1 = orderService.selectCustomerNum(cusQueryParam);
        /*if (customerNum1.getCreateNum() == null){
            customerNum1.setCreateNumN(String.valueOf(0));
        }*/
        customerNum1.setCreateNumN(customerNum1.getCreateNum().toString());
        customerNum1.setEndNumN(customerNum1.getEndNum().toString());
        customerNum1.setBeforeEndNumN(customerNum1.getBeforeEndNum().toString());
        customerNum1.setTableName("当月实绩");

        LmCusQueryParam lmCusQueryParam = new LmCusQueryParam(7,Integer.valueOf(startYear),Integer.valueOf(startMon) - 1,0,0,0,0);
        CustomerNum customerNum2 = orderService.selectLm(lmCusQueryParam);
        customerNum1.setLmCusNumN(customerNum2.getLmCusNum().toString());
        customerNum1.setTmCusNum(customerNum2.getLmCusNum() + customerNum1.getCreateNum() - customerNum1.getEndNum() - customerNum1.getBeforeEndNum());
        customerNum1.setTmCusNumN(customerNum1.getTmCusNum().toString());
        list.add(customerNum1);

        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }
}
