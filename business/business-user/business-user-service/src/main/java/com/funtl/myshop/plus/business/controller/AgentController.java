package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.AgentParamDto;
import com.funtl.myshop.plus.business.dto.EmpParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.CreditAgentService;
import com.funtl.myshop.plus.provider.api.EmpBaseService;
import com.funtl.myshop.plus.provider.domain.CreditAgent;
import com.funtl.myshop.plus.provider.domain.EmpBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 代理人设置信息
 */
@Api(tags = "代理人设置相关操作")
@RestController
@RequestMapping(value = "agent")
public class AgentController {
    @Reference(version = "1.0.0")
    private CreditAgentService creditAgentService;

    @Reference(version = "1.0.0")
    private EmpBaseService empBaseService;

    @ApiOperation(value = "新建代理人设置")
    @PostMapping(value = "insert")
    public ResponseResult<String> insert(@ApiParam(value = "代理人数据") @Valid @RequestBody AgentParamDto agentParamDto){
        if(agentParamDto.getCreditAgentAuto() != 0){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);
        }
        EmpBase empBase1 = empBaseService.selectById(agentParamDto.getSelfUser());
        EmpBase empBase2 = empBaseService.selectById(agentParamDto.getAgentUser());
        if(empBase1 == null || empBase2 == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "本人姓名或代理人姓名不存在", null);
        }
        CreditAgent creditAgent = new CreditAgent();
        BeanUtils.copyProperties(agentParamDto,creditAgent);
        creditAgent.setSelfUser(empBase1.getEmpBaseAuto());
        creditAgent.setSelfUSerDept(empBase1.getOrgAuto());
        creditAgent.setAgentUser(empBase2.getEmpBaseAuto());
        creditAgent.setAgentUserDept(empBase2.getOrgAuto());
        Long i = creditAgentService.insert(creditAgent);
        if(i == 0){
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

    @ApiOperation(value = "编辑代理人设置")
    @PutMapping(value = "update")
    public ResponseResult<String> update(@ApiParam(value = "代理人数据") @Valid @RequestBody AgentParamDto agentParamDto){
        EmpBase empBase1 = empBaseService.selectById(agentParamDto.getSelfUser());
        EmpBase empBase2 = empBaseService.selectById(agentParamDto.getAgentUser());
        if(empBase1 == null || empBase2 == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "本人姓名或代理人姓名不存在", null);
        }
        CreditAgent creditAgent = creditAgentService.selectById(agentParamDto.getCreditAgentAuto());
        BeanUtils.copyProperties(agentParamDto,creditAgent);
        creditAgent.setSelfUser(empBase1.getEmpBaseAuto());
        creditAgent.setSelfUSerDept(empBase1.getOrgAuto());
        creditAgent.setAgentUser(empBase2.getEmpBaseAuto());
        creditAgent.setAgentUserDept(empBase2.getOrgAuto());
        Integer i = creditAgentService.update(creditAgent);
        if(i == 0){
            throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "修改成功", null);
    }

    public ResponseResult<CreditAgent> patch(Byte isOn, Long creditAgentAuto) {
        CreditAgent creditAgent = creditAgentService.selectById(creditAgentAuto);
        if (creditAgent == null) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "未查询到代理人设置信息", null);
        }
        creditAgent.setIsOn(isOn);
        Integer i = creditAgentService.update(creditAgent);
        if (i == 0) {
            throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "修改成功", null);
    }


    @ApiOperation(value = "停用状态")
    @ApiImplicitParam(name = "creditAgentAuto", value = "代理人绑定表id", required = true, dataType = "long", paramType = "path")
    @PatchMapping("/stop/{creditAgentAuto}")
    public ResponseResult<CreditAgent> patchStop(@PathVariable(value = "creditAgentAuto") Long creditAgentAuto) {
        return patch((byte)0, creditAgentAuto);
    }

    @ApiOperation(value = "正常状态")
    @ApiImplicitParam(name = "creditAgentAuto", value = "代理人绑定表id", required = true, dataType = "long", paramType = "path")
    @PatchMapping("/start/{creditAgentAuto}")
    public ResponseResult<CreditAgent> patchStart(@PathVariable(value = "creditAgentAuto") Long creditAgentAuto) {
        return patch((byte)1, creditAgentAuto);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "creditAgentAuto", value = "代理人绑定表id", required = true, dataType = "long", paramType = "path")
    @DeleteMapping("/delete/{creditAgentAuto}")
    public ResponseResult<CreditAgent> delete(@PathVariable(value = "creditAgentAuto") Long creditAgentAuto) {
        return patch((byte)2, creditAgentAuto);
    }
}
