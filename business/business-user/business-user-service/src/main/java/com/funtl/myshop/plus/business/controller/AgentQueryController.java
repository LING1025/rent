package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.CreditAgentService;
import com.funtl.myshop.plus.provider.api.EmpBaseService;
import com.funtl.myshop.plus.provider.domain.EmpBase;
import com.funtl.myshop.plus.provider.dto.SelfAgentListDto;
import com.funtl.myshop.plus.provider.dto.SelfAgentQueryParam;
import com.github.pagehelper.PageInfo;
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
 * 代理人设置信息
 */
@Api(tags = "代理人设置查询相关操作")
@RestController
@RequestMapping(value = "query")
public class AgentQueryController {
    @Reference(version = "1.0.0")
    private CreditAgentService creditAgentService;

    @Reference(version = "1.0.0")
    private EmpBaseService empBaseService;

    @ApiOperation(value = " 根据本人id获取代理数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "empBaseAuto", value = "本人id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryBySelf")
    public ResponseResult<PageInfo<SelfAgentListDto>> queryBySelf(@RequestParam(name = "empBaseAuto",required = false) Long empBaseAuto,
                                                            @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                            @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize){
        //本人姓名查询
        PageInfo<SelfAgentListDto> pageInfo = creditAgentService.selectSelf(empBaseAuto, pageNum, pageSize);
        for(SelfAgentListDto dto : pageInfo.getList()){
            EmpBase empBase = empBaseService.selectById(dto.getSelfUser());
            if (empBase != null){
                dto.setSelfName(empBase.getFName());
                dto.setSelfDept(empBase.getOrgName());
            }
            EmpBase eb = empBaseService.selectById(dto.getAgentUser());
            if(eb != null){
                dto.setAgentName(eb.getFName());
                dto.setAgentDept(eb.getOrgName());
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
    }

    @ApiOperation(value = " 根据代理人id获取代理数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "empBaseAuto", value = "代理人id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryByAgent")
    public ResponseResult<PageInfo<SelfAgentListDto>> queryByAgent(@RequestParam(name = "empBaseAuto",required = false) Long empBaseAuto,
                                                                   @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                                   @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize){
                //代理人姓名查询
                PageInfo<SelfAgentListDto> pageInfo = creditAgentService.selectAgent(empBaseAuto, pageNum, pageSize);
                for(SelfAgentListDto dto : pageInfo.getList()){
                    EmpBase empBase = empBaseService.selectById(dto.getAgentUser());
                    if (empBase != null){
                        dto.setAgentName(empBase.getFName());
                        dto.setAgentDept(empBase.getOrgName());
                    }
                    EmpBase eb = empBaseService.selectById(dto.getSelfUser());
                    if(eb != null){
                        dto.setSelfName(eb.getFName());
                        dto.setSelfDept(eb.getOrgName());
                    }
                }
                return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
    }

}
