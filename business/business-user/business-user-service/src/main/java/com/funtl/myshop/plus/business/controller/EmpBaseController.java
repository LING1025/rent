package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.EmpParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        empParamDto.setCDT(new Date());
        empParamDto.setMDT(new Date());

        Org org = orgService.selectById(empParamDto.getOrgAuto());
        if(org == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "部门不存在", null);
        }

        IncTitle incTitle = incTitleService.selectById(empParamDto.getIncTitleAuto());
        if(incTitle == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "职位不存在", null);
        }

        OrgGroup orgGroup = orgGroupService.selectByOrgGroupName(empParamDto.getOrgGroupName());
        if(orgGroup == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "所属组不存在", null);
        }

        EmpBase eb = empBaseService.selectUsername(empParamDto.getUsername());
        if(eb != null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "用户名已存在，请重新命名", null);
        }

        //EmpBase插入数据
        EmpBase empBase = new EmpBase();
        BeanUtils.copyProperties(empParamDto,empBase);
        empBase.setExtension("");
        empBase.setTradeItemAuto(0L);
        empBase.setOrgAuto(org.getOrgAuto());
        empBase.setOrgName(org.getDepName());
        empBase.setOrgGroupAuto(orgGroup.getOrgGroupAuto());
        empBase.setOrgGroupName(orgGroup.getOrgGroupName());
        Long i2 = empBaseService.insert(empBase);
        if(i2 == 0){
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }

        //aspnetUsers插入数据
        AspnetUsers aspnetUsers = new AspnetUsers();
        BeanUtils.copyProperties(empParamDto,aspnetUsers);
        aspnetUsers.setLoweredUserName(empParamDto.getUsername().toLowerCase());
        aspnetUsers.setEmpBaseAuto(i2);
        Long i1 = aspnetUsersService.insert(aspnetUsers);
        if(i1 == 0){
            empBaseService.deleteById(i2);
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
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
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }

        for (String role : empParamDto.getRoles()
             ) {
            AspnetRoles aspnetRoles = aspnetRolesService.selectByRoleName(role);
            if(aspnetRoles == null){
                aspnetUsersService.deleteById(i1);
                empBaseService.deleteById(i2);
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "角色'"+role+"'不存在", null);
            }
            //Roles2Emp插入数据
            Roles2Emp roles2Emp = new Roles2Emp();
            roles2Emp.setEmpBaseAuto(i2);
            roles2Emp.setRoles_Auto(aspnetRoles.getRolesAuto());
            Long i4 = roles2EmpService.insert(roles2Emp);
            if(i4 == 0){
                aspnetUsersService.deleteById(i1);
                empBaseService.deleteById(i2);
                throw new BusinessException(BusinessStatus.SAVE_FAILURE);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

    @ApiOperation(value = "编辑员工")
    @PutMapping(value = "update")
    public ResponseResult<String> update(@ApiParam(value = "员工数据") @Valid @RequestBody EmpParamDto empParamDto){
        empParamDto.setCDT(new Date());
        empParamDto.setMDT(new Date());
        EmpBase empBase = empBaseService.selectById(empParamDto.getEmpBaseAuto());
        if(empBase == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "员工不存在", null);
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
        if(orgGroup == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "所属组不存在", null);
        }

        //判断是否修改了用户名
        if(!empBase.getUsername().equals(empParamDto.getUsername())){
            EmpBase eb = empBaseService.selectUsername(empParamDto.getUsername());
            if(eb != null){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "用户名已存在，请重新命名", null);
            }
            AspnetUsers aspnetUsers = aspnetUsersService.selectByEmpAuto(empBase.getEmpBaseAuto());
            BeanUtils.copyProperties(empParamDto,aspnetUsers);
            aspnetUsers.setLoweredUserName(empParamDto.getUsername().toLowerCase());
            Integer i1 = aspnetUsersService.update(aspnetUsers);
            if (i1 == 0){
                throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
            }

        }

        //判断是否修改了部门
        if(!empBase.getOrgAuto().equals(empParamDto.getOrgAuto())){
            AspnetUsers au = aspnetUsersService.selectByEmpAuto(empBase.getEmpBaseAuto());
            Org2Emp org2Emp = org2EmpService.selectByUserAuto(au.getUserAuto());
            org2Emp.setOrgAuto(org.getOrgAuto());
            Integer i2 = org2EmpService.update(org2Emp);
            if(i2 == 0){
                throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
            }
        }

        BeanUtils.copyProperties(empParamDto,empBase);
        empBase.setExtension("");
        empBase.setTradeItemAuto(0L);
        empBase.setOrgAuto(org.getOrgAuto());
        empBase.setOrgName(org.getDepName());
        empBase.setOrgGroupAuto(orgGroup.getOrgGroupAuto());
        empBase.setOrgGroupName(orgGroup.getOrgGroupName());
        empBase.setMDT(new Date());
        Integer i = empBaseService.update(empBase);
        if (i == 0) {
            throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
        }

        roles2EmpService.deleteByEmpAuto(empBase.getEmpBaseAuto());
        for (String role : empParamDto.getRoles()
        ) {
            AspnetRoles aspnetRoles = aspnetRolesService.selectByRoleName(role);
            if(aspnetRoles == null){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "角色'"+role+"'不存在", null);
            }

            //Roles2Emp插入数据
            Roles2Emp roles2Emp = new Roles2Emp();
            roles2Emp.setRoles_Auto(aspnetRoles.getRolesAuto());
            roles2Emp.setEmpBaseAuto(empBase.getEmpBaseAuto());
            Long i4 = roles2EmpService.insert(roles2Emp);
            if(i4 == 0){
                throw new BusinessException(BusinessStatus.SAVE_FAILURE);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "修改成功", null);
    }

    public ResponseResult<EmpBase> patch(Integer isOn, Long empBaseAuto) {
        EmpBase empBase = empBaseService.selectById(empBaseAuto);
        if (empBase == null) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "员工不存在", null);
        }
        empBase.setIsOn(isOn);
        Integer i = empBaseService.update(empBase);
        if (i == 0) {
            throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "修改成功", null);
    }


    @ApiOperation(value = "停用状态")
    @ApiImplicitParam(name = "empBaseAuto", value = "员工id", required = true, dataType = "long", paramType = "path")
    @PatchMapping("/stop/{empBaseAuto}")
    public ResponseResult<EmpBase> patchStop(@PathVariable(value = "empBaseAuto") Long empBaseAuto) {
        return patch(0, empBaseAuto);
    }

    @ApiOperation(value = "正常状态")
    @ApiImplicitParam(name = "empBaseAuto", value = "员工id", required = true, dataType = "long", paramType = "path")
    @PatchMapping("/start/{empBaseAuto}")
    public ResponseResult<EmpBase> patchStart(@PathVariable(value = "empBaseAuto") Long empBaseAuto) {
        return patch(1, empBaseAuto);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "empBaseAuto", value = "员工id", required = true, dataType = "long", paramType = "path")
    @DeleteMapping("/delete/{empBaseAuto}")
    public ResponseResult<EmpBase> delete(@PathVariable(value = "empBaseAuto") Long empBaseAuto) {
        return patch(2, empBaseAuto);
    }
}
