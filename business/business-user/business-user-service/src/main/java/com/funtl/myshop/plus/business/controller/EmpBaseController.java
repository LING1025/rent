package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.EmpParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.AspnetRoles;
import com.funtl.myshop.plus.provider.domain.IncTitle;
import com.funtl.myshop.plus.provider.domain.Org;
import com.funtl.myshop.plus.provider.domain.OrgGroup;
import com.funtl.myshop.plus.provider.dto.EmpListDto;
import com.funtl.myshop.plus.provider.dto.EmpQueryParam;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 员工信息
 */
@Api(tags = "员工相关操作")
@RestController
@RequestMapping(value = "emp")
public class EmpBaseController {
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

    @ApiOperation(value = " 根据员工姓名、部门查询员工信息")
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

    @ApiOperation(value = "新建员工")
    @PostMapping(value = "insert")
    public ResponseResult<String> insert(@ApiParam(value = "员工数据") @Valid @RequestBody EmpParamDto empParamDto){
        if(empParamDto.getEmpBaseAuto() != 0){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);
        }
        Org org = orgService.selectById(empParamDto.getOrgAuto());
        if(org == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "部门不存在", null);
        }
        IncTitle incTitle = incTitleService.selectById(empParamDto.getIncTitleAuto());
        if(incTitle == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "职位不存在", null);
        }
        OrgGroup orgGroup = orgGroupService.selectByOrgGroupName(empParamDto.getOrgGroupName());
        AspnetRoles aspnetRoles = aspnetRolesService.selectByRoleName(empParamDto.getRoleName());
        //todo:aspnet_UserInRoles\aspnet_UserInRolesLog\Roles2org\Roles2Emp\Org2Emp新增这些关系表，保存数据
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

}
