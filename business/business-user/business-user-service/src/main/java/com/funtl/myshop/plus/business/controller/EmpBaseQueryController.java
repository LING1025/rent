package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.EmpListDto;
import com.funtl.myshop.plus.provider.dto.EmpQueryParam;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工信息
 */
@Api(tags = "员工查询相关操作")
@RestController
@RequestMapping(value = "empQuery")
public class EmpBaseQueryController {
    @Reference(version = "1.0.0")
    private EmpBaseService empBaseService;

    @Reference(version = "1.0.0")
    private OrgService orgService;

    @Reference(version = "1.0.0")
    private IncTitleService incTitleService;

    @Reference(version = "1.0.0")
    private OrgGroupService orgGroupService;

    @Reference(version = "1.0.0")
    private AspnetRolesService aspnetRolesService;

    @ApiOperation(value = " 根据员工姓名、部门获取员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fName", value = "员工姓名", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "orgName", value = "部门名称", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "query")
    public ResponseResult<PageInfo<EmpListDto>> query(@RequestParam(name = "fName",required = false) String fName,
                                                      @RequestParam(name = "orgName",required = false) String orgName,
                                                      @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize){
        EmpQueryParam empQueryParam = new EmpQueryParam(orgName,fName,pageNum,pageSize);
        PageInfo<EmpListDto> pageInfo = empBaseService.selectEmpListDto(empQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
    }

    @ApiOperation(value = " 根据员工id获取员工代理信息")
    @ApiImplicitParam(name = "empBaseAuto", value = "员工id", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryByEmpBaseAuto")
    public ResponseResult<List<EmpAgentList>> queryByEmpBaseAuto(@RequestParam(name = "empBaseAuto",required = false) Long empBaseAuto) {
        List<EmpAgentList> empAgentList = empBaseService.selectEmpAgent(empBaseAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", empAgentList);
    }

    @ApiOperation(value = " 获取部门名称")
    @ApiImplicitParam(name = "depName", value = "部门名称", required = false, dataType = "string", paramType = "path")
    @GetMapping(value = "queryDepName")
    public ResponseResult<List<OrgNameList>> queryDepName(@RequestParam(name = "depName",required = false) String depName){
        List<OrgNameList> lists = orgService.selectOrgName(depName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 获取角色名称")
    @ApiImplicitParam(name = "roleName", value = "角色名称", required = false, dataType = "string", paramType = "path")
    @GetMapping(value = "queryRoleName")
    public ResponseResult<List<RolesNameList>> queryRoleName(@RequestParam(name = "roleName",required = false) String roleName){
        List<RolesNameList> lists = aspnetRolesService.selectRoleName(roleName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 获取所属组名称")
    @ApiImplicitParam(name = "orgGroupName", value = "所属组名称", required = false, dataType = "string", paramType = "path")
    @GetMapping(value = "queryOrgGroupName")
    public ResponseResult<List<OrgGroupNameList>> queryOrgGroupName(@RequestParam(name = "orgGroupName",required = false) String orgGroupName){
        List<OrgGroupNameList> lists = orgGroupService.selectOrgGroupName(orgGroupName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }
}
