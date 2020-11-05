package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
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

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 报表信息管理
 */

@Api(tags = "营业报表相关操作")
@RestController
@RequestMapping(value = "table")
public class TableController {

    @Reference(version = "1.0.0")
    private VEmpService vEmpService;

    @Reference(version = "1.0.0")
    private OrderService orderService;

    @ApiOperation(value = "获取营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "用户id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "orgUpAuto", value = "上级部门id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryMode")
    public ResponseResult<List<ReportFormTwo>> queryMode(@RequestParam(name = "userAuto",required = false) Long userAuto,
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
        LineChartQueryParam lineChartQueryParam = new LineChartQueryParam(userAuto,startDate,endDate,orgAuto,orgUpAuto);
        List<ReportForms> list = vEmpService.selectMode(lineChartQueryParam);
        NumberFormat nt = NumberFormat.getPercentInstance();//getPercentInstance()百分比
        // 设置百分数精确度2即保留两位小数
//        nt.setMinimumFractionDigits(2);
        List<ReportFormTwo> reportFormsList = Lists.newArrayList();
        for(ReportForms reportForms : list){
            ReportFormTwo rs = new ReportFormTwo();
            BeanUtils.copyProperties(reportForms,rs);
            rs.setPLv(nt.format(reportForms.getPaperLv()));
            rs.setCLv(nt.format(reportForms.getCountLv()));
            rs.setVLv(nt.format(reportForms.getVolumeLv()));
            reportFormsList.add(rs);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",reportFormsList);
    }

    @ApiOperation(value = "获取试算营业报表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "用户id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "orgUpAuto", value = "上级部门id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "query")
    public ResponseResult<YearMonthList> query(@RequestParam(name = "userAuto",required = false) Long userAuto,
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
        LineChartQueryParam lineChartQueryParam = new LineChartQueryParam(userAuto,startDate,endDate,orgAuto,orgUpAuto);
        List<MonthListDto> monthListDtos = vEmpService.selectTest(lineChartQueryParam);
        List<PCountMoneys> thisMonth = Lists.newArrayList();
        List<PCountMoneyLast> lastMonth = Lists.newArrayList();
        for(MonthListDto monthListDto : monthListDtos){
            //本月
            PCountMoneys pCountMoneys = new PCountMoneys();
            BeanUtils.copyProperties(monthListDto,pCountMoneys);
            //上个月
            PCountMoneyLast pCountMoneyLast = new PCountMoneyLast();
            BeanUtils.copyProperties(monthListDto,pCountMoneyLast);
            pCountMoneyLast.setYearMonLast(monthListDto.getYearMon());
            pCountMoneyLast.setDaysLast(monthListDto.getDays());
            pCountMoneyLast.setPCountLast(monthListDto.getPCount());
            pCountMoneyLast.setPMoneyLast(monthListDto.getPMoney());

            if(monthListDto.getYearMon() == null || monthListDto.getYearMon().split("-")[1].equals(startMon)){
                thisMonth.add(pCountMoneys);
            }
            if(monthListDto.getYearMon() == null || !monthListDto.getYearMon().split("-")[1].equals(startMon)){
                lastMonth.add(pCountMoneyLast);
            }
        }
        YearMonthList yearMonthList = new YearMonthList();
        yearMonthList.setThisMonth(thisMonth);
        yearMonthList.setLastMonth(lastMonth);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",yearMonthList);
    }

    @ApiOperation(value = "新增契约租金-客户来源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "用户id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "orgUpAuto", value = "上级部门id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryRentAmtList")
    public ResponseResult<List<RentAmtList>> queryThisMonthTar(@RequestParam(name = "userAuto",required = false) Long userAuto,
                                                                @RequestParam(name = "startDate",required = false) String startDate,
                                                                @RequestParam(name = "endDate",required = false) String endDate,
                                                                @RequestParam(name = "orgAuto",defaultValue = "0") Long orgAuto,
                                                                @RequestParam(name = "orgUpAuto",defaultValue = "0") Long orgUpAuto) throws ParseException {
        if(startDate == null || endDate == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：查询日期不能为空",null);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = format.parse(startDate);
        Date date2 = format.parse(endDate);
        if(date1.after(date2)){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：开始日期必须小于结束日期",null);
        }
        String startYear = startDate.split("/")[0];
        String startMon = startDate.split("/")[1];

        List<RentAmtList> list = Lists.newArrayList();
        NumberFormat nt = NumberFormat.getPercentInstance();//getPercentInstance()百分比

        //当月目标
        LineChartQueryParam lineChartQueryParam = new LineChartQueryParam(userAuto,startDate,endDate,orgAuto,orgUpAuto);
        ThisMonthTar thisMonthTar1 = orderService.selectThisMonGoal(lineChartQueryParam);

        //当月实绩
        MonGoalQueryParam monGoalQueryParam = new MonGoalQueryParam(0,4,startYear,startMon,1,"",startDate,endDate,3);
        ThisMonthTar thisMonthTar2 = orderService.selectThisMonReal(monGoalQueryParam);

        RentAmtList rentAmtList = new RentAmtList();
        RentAmtList rentAmtList1 = new RentAmtList();
        RentAmtList rentAmtList2 = new RentAmtList();
        RentAmtList rentAmtList3 = new RentAmtList();

        //标题
        rentAmtList.setTitleName("新增契约租金(①+②+③)");
        rentAmtList1.setTitleName("客户来源-新拓①");
        rentAmtList2.setTitleName("客户来源-保有②");
        rentAmtList3.setTitleName("客户来源-介绍③");

        //当月目标
        rentAmtList.setThisMonTar(thisMonthTar1.getTotalNumAmt());
        rentAmtList1.setThisMonTar(thisMonthTar1.getNewExs());
        rentAmtList2.setThisMonTar(thisMonthTar1.getRetain());
        rentAmtList3.setThisMonTar(thisMonthTar1.getIntroduce());

        //当月实绩
        rentAmtList.setThisMonAct(thisMonthTar2.getTotalNumAmt());
        rentAmtList1.setThisMonAct(thisMonthTar2.getNewExs());
        rentAmtList2.setThisMonAct(thisMonthTar2.getRetain());
        rentAmtList3.setThisMonAct(thisMonthTar2.getIntroduce());


        //结构比
        rentAmtList.setStructure("100%");
        if(thisMonthTar2.getTotalNumAmt().toString().equals("0.00")){
            rentAmtList1.setStructure("-");
            rentAmtList2.setStructure("-");
            rentAmtList3.setStructure("-");
        }else {
            rentAmtList1.setStructure(nt.format(thisMonthTar2.getNewExs().divide(thisMonthTar2.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList2.setStructure(nt.format(thisMonthTar2.getRetain().divide(thisMonthTar2.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList3.setStructure(nt.format(thisMonthTar2.getIntroduce().divide(thisMonthTar2.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
        }
        //达成率
        if(thisMonthTar1.getTotalNumAmt().toString().equals("0.00")){
            rentAmtList.setReach("-");
            rentAmtList1.setReach("-");
            rentAmtList2.setReach("-");
            rentAmtList3.setReach("-");
        }else {
            rentAmtList.setReach(nt.format(thisMonthTar2.getTotalNumAmt().divide(thisMonthTar1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList1.setReach(nt.format(thisMonthTar2.getNewExs().divide(thisMonthTar1.getNewExs(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList2.setReach(nt.format(thisMonthTar2.getRetain().divide(thisMonthTar1.getRetain(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList3.setReach(nt.format(thisMonthTar2.getIntroduce().divide(thisMonthTar1.getIntroduce(), 2, BigDecimal.ROUND_HALF_UP)));
        }
        //上月实绩
        //过去一月
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(endDate));
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        String lastStartMon = mon.split("/")[1];
        String lastStartYear = mon.split("/")[0];
        String lastStartDate = lastStartYear + "/" +lastStartMon + "/" + startDate.split("/")[2];

        MonGoalQueryParam monGoalQueryParam2 = new MonGoalQueryParam(0,4,lastStartYear,lastStartMon,1,"",lastStartDate,mon,3);
        ThisMonthTar thisMonthTar5 = orderService.selectThisMonReal(monGoalQueryParam2);
        rentAmtList.setLastMonAct(thisMonthTar5.getTotalNumAmt());
        rentAmtList1.setLastMonAct(thisMonthTar5.getNewExs());
        rentAmtList2.setLastMonAct(thisMonthTar5.getRetain());
        rentAmtList3.setLastMonAct(thisMonthTar5.getIntroduce());

        //环比
        if (thisMonthTar5.getNewExs().toString().equals("0.00")){
            rentAmtList.setLink("-");
            rentAmtList1.setLink("-");
            rentAmtList2.setLink("-");
            rentAmtList3.setLink("-");

        }else {
            rentAmtList.setLink(nt.format(thisMonthTar2.getTotalNumAmt().divide(thisMonthTar5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
            rentAmtList1.setLink(nt.format(thisMonthTar2.getNewExs().divide(thisMonthTar5.getNewExs(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
            rentAmtList2.setLink(nt.format(thisMonthTar2.getRetain().divide(thisMonthTar5.getRetain(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
            rentAmtList3.setLink(nt.format(thisMonthTar2.getIntroduce().divide(thisMonthTar5.getIntroduce(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }
        //去年实绩
        //过去一年
        Calendar c2 = Calendar.getInstance();
        c2.setTime(format.parse(endDate));
        c2.add(Calendar.YEAR, -1);
        Date y = c2.getTime();
        String year = format.format(y);
        String lastYear = year.split("/")[0];
        String lastSD = lastYear + "/" + startMon + "/" + startDate.split("/")[2];
        MonGoalQueryParam monGoalQueryParam3 = new MonGoalQueryParam(0,4,lastYear,startMon,1,"",lastSD,year,3);
        ThisMonthTar thisMonthTar7 = orderService.selectThisMonReal(monGoalQueryParam3);
        rentAmtList.setLastYearAct(thisMonthTar7.getTotalNumAmt());
        rentAmtList1.setLastYearAct(thisMonthTar7.getNewExs());
        rentAmtList2.setLastYearAct(thisMonthTar7.getRetain());
        rentAmtList3.setLastYearAct(thisMonthTar7.getIntroduce());

        //结构比
        rentAmtList.setConstruction("100%");
        if(thisMonthTar7.getTotalNumAmt().toString().equals("0.00")){
            rentAmtList1.setConstruction("-");
            rentAmtList2.setConstruction("-");
            rentAmtList3.setConstruction("-");

        }else {
            rentAmtList1.setConstruction(nt.format(thisMonthTar7.getNewExs().divide(thisMonthTar7.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));//四舍五入保留两位小数
            rentAmtList2.setConstruction(nt.format(thisMonthTar7.getRetain().divide(thisMonthTar7.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));//四舍五入保留两位小数
            rentAmtList3.setConstruction(nt.format(thisMonthTar7.getIntroduce().divide(thisMonthTar7.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));//四舍五入保留两位小数
        }
        //同期对比
        if (thisMonthTar7.getNewExs().toString().equals("0.00")){
            rentAmtList.setComparison("-");
            rentAmtList1.setComparison("-");
            rentAmtList2.setComparison("-");
            rentAmtList3.setComparison("-");
        }else {
            rentAmtList.setComparison(nt.format(thisMonthTar2.getTotalNumAmt().divide(thisMonthTar7.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
            rentAmtList1.setComparison(nt.format(thisMonthTar2.getNewExs().divide(thisMonthTar7.getNewExs(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
            rentAmtList2.setComparison(nt.format(thisMonthTar2.getRetain().divide(thisMonthTar7.getRetain(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
            rentAmtList3.setComparison(nt.format(thisMonthTar2.getIntroduce().divide(thisMonthTar7.getIntroduce(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }
        //将数据插入到集合中
        list.add(rentAmtList);
        list.add(rentAmtList1);
        list.add(rentAmtList2);
        list.add(rentAmtList3);

        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

    @ApiOperation(value = "新增契约租金,台数-车辆来源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryCarRent")
    public ResponseResult<List<RentAmtList>> queryCarRent(@RequestParam(name = "startDate",required = false) String startDate,
                                                                  @RequestParam(name = "endDate",required = false) String endDate,
                                                                  @RequestParam(name = "typeQuery",required = false) Integer typeQuery) throws ParseException {
        if(startDate == null || endDate == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：查询日期不能为空",null);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date date1 = format.parse(startDate);
        Date date2 = format.parse(endDate);
        if(date1.after(date2)){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：开始日期必须小于结束日期",null);
        }
        String startYear = startDate.split("/")[0];
        String startMon = startDate.split("/")[1];
        List<RentAmtList> list = Lists.newArrayList();
        NumberFormat nt = NumberFormat.getPercentInstance();//getPercentInstance()百分比

        //当月实绩
        MonGoalQueryParam monGoalQueryParam = new MonGoalQueryParam(0,4,startYear,startMon,1,"",startDate,endDate,typeQuery);
        CarSourceRent carSourceRent1 = orderService.selectCarSourceRent(monGoalQueryParam);

        RentAmtList rentAmtList = new RentAmtList();
        RentAmtList rentAmtList1 = new RentAmtList();
        RentAmtList rentAmtList2 = new RentAmtList();
        RentAmtList rentAmtList3 = new RentAmtList();
        RentAmtList rentAmtList4 = new RentAmtList();

        //标题
        rentAmtList.setTitleName("新增契约租金(①+②+③+④)");
        rentAmtList1.setTitleName("华东-车辆来源-新车①");
        rentAmtList2.setTitleName("华东-车辆来源-旧车②");
        rentAmtList3.setTitleName("华南-车辆来源-新车③");
        rentAmtList4.setTitleName("华南-车辆来源-旧车④");

        //当月实绩
        rentAmtList.setThisMonAct(carSourceRent1.getTotalNumAmt());
        rentAmtList1.setThisMonAct(carSourceRent1.getEastNewCar());
        rentAmtList2.setThisMonAct(carSourceRent1.getEastOldCar());
        rentAmtList3.setThisMonAct(carSourceRent1.getSouthNewCar());
        rentAmtList4.setThisMonAct(carSourceRent1.getSouthOldCar());

        //结构比
        rentAmtList.setStructure("100%");
        if (carSourceRent1.getTotalNumAmt().toString().equals("0.00")){
            rentAmtList1.setStructure("-");
            rentAmtList2.setStructure("-");
            rentAmtList3.setStructure("-");
            rentAmtList4.setStructure("-");
        }else {
            rentAmtList1.setStructure(nt.format(carSourceRent1.getEastNewCar().divide(carSourceRent1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList2.setStructure(nt.format(carSourceRent1.getEastOldCar().divide(carSourceRent1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList3.setStructure(nt.format(carSourceRent1.getSouthNewCar().divide(carSourceRent1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList4.setStructure(nt.format(carSourceRent1.getSouthOldCar().divide(carSourceRent1.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
        }

        //上月实绩
        //过去一月
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(endDate));
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        String lastStartMon = mon.split("/")[1];
        String lastStartYear = mon.split("/")[0];
        String lastStartDate = lastStartYear + "/" +lastStartMon + "/" + startDate.split("/")[2];
        MonGoalQueryParam monGoalQueryParam2 = new MonGoalQueryParam(0,4,lastStartYear,lastStartMon,1,"",lastStartDate,mon,typeQuery);
        CarSourceRent carSourceRent3 = orderService.selectCarSourceRent(monGoalQueryParam2);
        rentAmtList.setLastMonAct(carSourceRent3.getTotalNumAmt());
        rentAmtList1.setLastMonAct(carSourceRent3.getEastNewCar());
        rentAmtList2.setLastMonAct(carSourceRent3.getEastOldCar());
        rentAmtList3.setLastMonAct(carSourceRent3.getSouthNewCar());
        rentAmtList4.setLastMonAct(carSourceRent3.getSouthOldCar());

        //环比
        if (carSourceRent3.getTotalNumAmt().toString().equals("0.00")){
            rentAmtList.setLink("-");
        }else {
            rentAmtList.setLink(nt.format(carSourceRent1.getTotalNumAmt().divide(carSourceRent3.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        if (carSourceRent3.getEastNewCar().toString().equals("0.00")){
            rentAmtList1.setLink("-");
        }else {
            rentAmtList1.setLink(nt.format(carSourceRent1.getEastNewCar().divide(carSourceRent3.getEastNewCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        if (carSourceRent3.getEastOldCar().toString().equals("0.00")){
            rentAmtList2.setLink("-");
        }else {
            rentAmtList2.setLink(nt.format(carSourceRent1.getEastOldCar().divide(carSourceRent3.getEastOldCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        if (carSourceRent3.getSouthNewCar().toString().equals("0.00")){
            rentAmtList3.setLink("-");
        }else {
            rentAmtList3.setLink(nt.format(carSourceRent1.getSouthNewCar().divide(carSourceRent3.getSouthNewCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        if (carSourceRent3.getSouthOldCar().toString().equals("0.00")){
            rentAmtList4.setLink("-");
        }else {
            rentAmtList4.setLink(nt.format(carSourceRent1.getSouthOldCar().divide(carSourceRent3.getSouthOldCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        //去年实绩
        //过去一年
        Calendar c2 = Calendar.getInstance();
        c2.setTime(format.parse(endDate));
        c2.add(Calendar.YEAR, -1);
        Date y = c2.getTime();
        String year = format.format(y);
        String lastYear = year.split("/")[0];
        String lastSD = lastYear + "/" + startMon + "/" + startDate.split("/")[2];
        MonGoalQueryParam monGoalQueryParam3 = new MonGoalQueryParam(0,4,lastYear,startMon,1,"",lastSD,year,typeQuery);
        CarSourceRent carSourceRent5 = orderService.selectCarSourceRent(monGoalQueryParam3);
        rentAmtList.setLastYearAct(carSourceRent5.getTotalNumAmt());
        rentAmtList1.setLastYearAct(carSourceRent5.getEastNewCar());
        rentAmtList2.setLastYearAct(carSourceRent5.getEastOldCar());
        rentAmtList3.setLastYearAct(carSourceRent5.getSouthNewCar());
        rentAmtList4.setLastYearAct(carSourceRent5.getSouthOldCar());

        //结构比
        rentAmtList.setConstruction("100%");
        if (carSourceRent1.getTotalNumAmt().toString().equals("0.00")){
            rentAmtList1.setConstruction("-");
            rentAmtList2.setConstruction("-");
            rentAmtList3.setConstruction("-");
            rentAmtList4.setConstruction("-");
        }else {
            rentAmtList1.setConstruction(nt.format(carSourceRent5.getEastNewCar().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList2.setConstruction(nt.format(carSourceRent5.getEastOldCar().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList3.setConstruction(nt.format(carSourceRent5.getSouthNewCar().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
            rentAmtList4.setConstruction(nt.format(carSourceRent5.getSouthOldCar().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP)));
        }

        //同期比较
        if (carSourceRent5.getTotalNumAmt().equals("0.00")){
            rentAmtList.setComparison("-");
        }else {
            rentAmtList.setComparison(nt.format(carSourceRent1.getTotalNumAmt().divide(carSourceRent5.getTotalNumAmt(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        if (carSourceRent5.getEastNewCar().toString().equals("0.00")){
            rentAmtList1.setComparison("-");
        }else {
            rentAmtList1.setComparison(nt.format(carSourceRent1.getEastNewCar().divide(carSourceRent5.getEastNewCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        if (carSourceRent5.getEastOldCar().toString().equals("0.00")){
            rentAmtList2.setComparison("-");
        }else {
            rentAmtList2.setComparison(nt.format(carSourceRent1.getEastOldCar().divide(carSourceRent5.getEastOldCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        if (carSourceRent5.getSouthNewCar().toString().equals("0.00")){
            rentAmtList3.setComparison("-");
        }else {
            rentAmtList3.setComparison(nt.format(carSourceRent1.getSouthNewCar().divide(carSourceRent5.getSouthNewCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }

        if (carSourceRent5.getSouthOldCar().toString().equals("0.00")){
            rentAmtList4.setComparison("-");
        }else {
            rentAmtList4.setComparison(nt.format(carSourceRent1.getSouthOldCar().divide(carSourceRent5.getSouthOldCar(), 2, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.valueOf(1))));
        }


        //将数据插入到集合中
        list.add(rentAmtList);
        list.add(rentAmtList1);
        list.add(rentAmtList2);
        list.add(rentAmtList3);
        list.add(rentAmtList4);

        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

    @ApiOperation(value = "保有客户台数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = false, dataType = "string", paramType = "path")
    })
    @GetMapping(value = "queryNum")
    public ResponseResult<List<RentAmtList>> queryNum(@RequestParam(name = "startDate",required = false) String startDate,
                                                              @RequestParam(name = "endDate",required = false) String endDate) throws ParseException {
        if(startDate == null || endDate == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：查询日期不能为空",null);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = format.parse(startDate);
        Date date2 = format.parse(endDate);
        if(date1.after(date2)){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：开始日期必须小于结束日期",null);
        }
        String startYear = startDate.split("/")[0];
        String startMon = startDate.split("/")[1];
        List<RentAmtList> list = Lists.newArrayList();


        RentAmtList rentAmtList1 = new RentAmtList();
        RentAmtList rentAmtList2 = new RentAmtList();
        RentAmtList rentAmtList3 = new RentAmtList();
        RentAmtList rentAmtList4 = new RentAmtList();
        RentAmtList rentAmtList5 = new RentAmtList();

        //标题
        rentAmtList1.setTitleName("新增业绩台数");
        rentAmtList2.setTitleName("前月保有客户台数");
        rentAmtList3.setTitleName("结清-期满解约");
        rentAmtList4.setTitleName("结清-提前解约");
        rentAmtList5.setTitleName("本月保有客户台数");

        //当月实绩
        CusQueryParam cusQueryParam1 = new CusQueryParam(7,Integer.valueOf(startYear),Integer.valueOf(startMon),0,0,0,0,startDate,endDate);
        CustomerNum customerNum1 = orderService.selectCustomerNum(cusQueryParam1);

        //前月保有
        //过去一月
        Integer lastY = Integer.valueOf(startYear);
        Integer lastM = Integer.valueOf(startMon) - 1;
        if (lastM == 0){
            lastM = 12;
            lastY = Integer.valueOf(startYear) - 1;
        }
        String lastStartDate = lastY.toString() + "/" + lastM.toString() + "/" + startDate.split("/")[2];
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(endDate));
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        CusQueryParam lmCusQueryParam1 = new CusQueryParam(7,lastY,lastM,0,0,0,0,lastStartDate,mon);
        CustomerNum customerNum2 = orderService.selectLm(lmCusQueryParam1);
        //当月实绩
        rentAmtList1.setThisMonAct(BigDecimal.valueOf(customerNum1.getCreateNum()));
        rentAmtList2.setThisMonAct(BigDecimal.valueOf(customerNum2.getLmCusNum()));
        rentAmtList3.setThisMonAct(BigDecimal.valueOf(customerNum2.getEndNum()));
        rentAmtList4.setThisMonAct(BigDecimal.valueOf(customerNum2.getBeforeEndNum()));
        customerNum1.setTmCusNum(customerNum2.getLmCusNum() + customerNum1.getCreateNum() - customerNum2.getEndNum() - customerNum2.getBeforeEndNum());
        rentAmtList5.setThisMonAct(BigDecimal.valueOf(customerNum1.getTmCusNum()));

        //上月实绩
        CusQueryParam cusQueryParam2 = new CusQueryParam(7,lastY,lastM,0,0,0,0,lastStartDate,mon);
        CustomerNum customerNum3 = orderService.selectCustomerNum(cusQueryParam2);

        //前月保有客户台数
        //过去两月
        Calendar c2 = Calendar.getInstance();
        c2.setTime(format.parse(endDate));
        c2.add(Calendar.MONTH, -2);
        Date m2 = c2.getTime();
        String mon2 = format.format(m2);
        Integer qYe = Integer.valueOf(mon2.split("/")[0]);
        Integer qMon = Integer.valueOf(mon2.split("/")[1]);
        String qStartDate = qYe.toString() + "/" + qMon.toString() + "/" + startDate.split("/")[2];

        CusQueryParam lmCusQueryParam2 = new CusQueryParam(7,qYe,qMon,0,0,0,0,qStartDate,mon2);
        CustomerNum customerNum4 = orderService.selectLm(lmCusQueryParam2);
        rentAmtList1.setLastMonAct(BigDecimal.valueOf(customerNum3.getCreateNum()));
        rentAmtList2.setLastMonAct(BigDecimal.valueOf(customerNum4.getLmCusNum()));
        rentAmtList3.setLastMonAct(BigDecimal.valueOf(customerNum4.getEndNum()));
        rentAmtList4.setLastMonAct(BigDecimal.valueOf(customerNum4.getBeforeEndNum()));
        customerNum3.setTmCusNum(customerNum4.getLmCusNum() + customerNum3.getCreateNum() - customerNum4.getEndNum() - customerNum4.getBeforeEndNum());
        rentAmtList5.setLastMonAct(BigDecimal.valueOf(customerNum3.getTmCusNum()));

        NumberFormat nt = NumberFormat.getPercentInstance();//getPercentInstance()百分比
        //设置百分数精确度2即保留两位小数
//        nt.setMinimumFractionDigits(2);

        //环比
        rentAmtList2.setLink(nt.format(customerNum2.getLmCusNum().doubleValue()/customerNum4.getLmCusNum().doubleValue() - 1));
        if (customerNum3.getCreateNum() == 0){
            rentAmtList1.setLink("-");
        }else {
            rentAmtList1.setLink(nt.format(customerNum1.getCreateNum().doubleValue()/customerNum3.getCreateNum().doubleValue() - 1));
        }

        if (customerNum4.getEndNum() == 0){
            rentAmtList3.setLink("-");
        }else {
            rentAmtList3.setLink(nt.format(customerNum2.getEndNum().doubleValue()/customerNum4.getEndNum().doubleValue() - 1));
        }

        if (customerNum4.getBeforeEndNum() == 0){
            rentAmtList4.setLink("-");
        }else {
            rentAmtList4.setLink(nt.format(customerNum2.getBeforeEndNum().doubleValue()/customerNum4.getBeforeEndNum().doubleValue() - 1));
        }

        rentAmtList5.setLink(nt.format(customerNum1.getTmCusNum().doubleValue()/customerNum3.getTmCusNum().doubleValue() - 1));

        //去年实绩
        //过去一年
        Calendar c3 = Calendar.getInstance();
        c3.setTime(format.parse(endDate));
        c3.add(Calendar.YEAR, -1);
        Date y = c3.getTime();
        String year = format.format(y);
        Integer lYear = Integer.valueOf(year.split("/")[0]);
        String lastSD = lYear.toString() + "/" + startMon + "/" + startDate.split("/")[2];
        CusQueryParam cusQueryParam3 = new CusQueryParam(7,lYear,Integer.valueOf(startMon),0,0,0,0,lastSD,year);
        CustomerNum customerNum6 = orderService.selectCustomerNum(cusQueryParam3);

        //前月保有客户台数
        //过去两年
        Calendar c4 = Calendar.getInstance();
        c4.setTime(format.parse(endDate));
        c4.add(Calendar.YEAR, -2);
        Date y2 = c4.getTime();
        String year2 = format.format(y2);
        Integer qY = Integer.valueOf(year2.split("/")[0]);
        String qSD = qY.toString() + "/" + startMon + "/" + startDate.split("/")[2];
        CusQueryParam lmCusQueryParam3 = new CusQueryParam(7,qY,Integer.valueOf(startMon),0,0,0,0,qSD,year2);
        CustomerNum customerNum7 = orderService.selectLm(lmCusQueryParam3);
        rentAmtList1.setLastYearAct(BigDecimal.valueOf(customerNum6.getCreateNum()));
        rentAmtList2.setLastYearAct(BigDecimal.valueOf(customerNum7.getLmCusNum()));
        rentAmtList3.setLastYearAct(BigDecimal.valueOf(customerNum7.getEndNum()));
        rentAmtList4.setLastYearAct(BigDecimal.valueOf(customerNum7.getBeforeEndNum()));
        customerNum6.setTmCusNum(customerNum7.getLmCusNum() + customerNum6.getCreateNum() - customerNum7.getEndNum() - customerNum7.getBeforeEndNum());
        rentAmtList5.setLastYearAct(BigDecimal.valueOf(customerNum6.getTmCusNum()));

        //同期对比
        rentAmtList2.setComparison(nt.format(customerNum2.getLmCusNum().doubleValue()/customerNum7.getLmCusNum().doubleValue() - 1));
        if (customerNum6.getCreateNum() == 0){
            rentAmtList1.setComparison("-");
        }else {
            rentAmtList1.setComparison(nt.format(customerNum1.getCreateNum().doubleValue()/customerNum6.getCreateNum().doubleValue() - 1));
        }

        if (customerNum7.getEndNum() == 0){
            rentAmtList3.setComparison("-");
        }else {
            rentAmtList3.setComparison(nt.format(customerNum2.getEndNum().doubleValue()/customerNum7.getEndNum().doubleValue() - 1));
        }

        if (customerNum7.getBeforeEndNum() == 0){
            rentAmtList4.setComparison("-");
        }else {
            rentAmtList4.setComparison(nt.format(customerNum2.getBeforeEndNum().doubleValue()/customerNum7.getBeforeEndNum().doubleValue() - 1));
        }
        rentAmtList5.setComparison(nt.format(customerNum1.getTmCusNum().doubleValue()/customerNum6.getTmCusNum().doubleValue() - 1));

        //将数据插入到集合中
        list.add(rentAmtList2);
        list.add(rentAmtList1);
        list.add(rentAmtList3);
        list.add(rentAmtList4);
        list.add(rentAmtList5);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }
}
