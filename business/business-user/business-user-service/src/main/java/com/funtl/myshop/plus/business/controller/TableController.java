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
}
