package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.EmpParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.EmpListDto;
import com.funtl.myshop.plus.provider.dto.EmpQueryParam;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

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

    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    @Reference(version = "1.0.0")
    private Org2EmpService org2EmpService;

    @Reference(version = "1.0.0")
    private Roles2EmpService roles2EmpService;

    @Reference(version = "1.0.0")
    private Roles2OrgService roles2OrgService;

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

        AspnetRoles aspnetRoles = aspnetRolesService.selectByRoleName(empParamDto.getRoleName());
        if(aspnetRoles == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "角色不存在", null);
        }

        OrgGroup orgGroup = orgGroupService.selectByOrgGroupName(empParamDto.getOrgGroupName());
        if(orgGroup == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "所属组不存在", null);
        }

        //aspnetUsers插入数据
        AspnetUsers aspnetUsers = new AspnetUsers();
        aspnetUsers.setApplicationId("73663109-DDA2-4C2D-8311-337946B5C373");
        aspnetUsers.setUserId("8FEE10B0-8BF9-4A91-91EF-B28941B73AB9");
        aspnetUsers.setIsAnonymous(false);
        aspnetUsers.setLastActivityDate(new Date());
        aspnetUsers.setUserName(empParamDto.getUsername());
        aspnetUsers.setLoweredUserName(empParamDto.getUsername().toLowerCase());
        aspnetUsers.setExtn("");
        Long i1 = aspnetUsersService.insert(aspnetUsers);
        if(i1 == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "保存失败", null);
        }

        //EmpBase插入数据
        EmpBase empBase = new EmpBase();
        BeanUtils.copyProperties(empParamDto,empBase);
        empBase.setExtension("");
        empBase.setTradeItemAuto(0L);
        empBase.setOrgName(org.getDepName());
        Long i2 = empBaseService.insert(empBase);
        if(i2 == 0){
            aspnetUsersService.deleteById(i1);
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "保存失败", null);
        }

        //Org2Emp插入数据
        Org2Emp org2Emp = new Org2Emp();
        org2Emp.setOrgAuto(org.getOrgAuto());
        org2Emp.setUserAuto(i1);
        org2Emp.setACLType(0);
        Long i3 = org2EmpService.insert(org2Emp);
        if(i3 == 0){
            aspnetUsersService.deleteById(i1);
            empBaseService.deleteById(i2);
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "保存失败", null);
        }

        //Roles2Emp插入数据
        Roles2Emp roles2Emp = new Roles2Emp();
        roles2Emp.setEmpBaseAuto(i2);
        roles2Emp.setRoles_Auto(aspnetRoles.getRolesAuto());
        Long i4 = roles2EmpService.insert(roles2Emp);
        if(i4 == 0){
            aspnetUsersService.deleteById(i1);
            empBaseService.deleteById(i2);
            org2EmpService.deleteById(i3);
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "保存失败", null);
        }

        //Roles2Org插入数据
        Roles2Org roles2Org = new Roles2Org();
        roles2Org.setOrgAuto(org.getOrgAuto());
        roles2Org.setRoles_Auto(aspnetRoles.getRolesAuto());
        Integer i5 = roles2OrgService.insert(roles2Org);
        if(i5 == 0){
            aspnetUsersService.deleteById(i1);
            empBaseService.deleteById(i2);
            org2EmpService.deleteById(i3);
            roles2EmpService.deleteById(i4);
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "保存失败", null);
        }

        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

}
