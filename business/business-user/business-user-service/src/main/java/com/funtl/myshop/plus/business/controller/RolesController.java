package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.AspnetRolesService;
import com.funtl.myshop.plus.provider.domain.RolesNameList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色信息
 */
@Api(tags = "角色相关操作")
@RestController
@RequestMapping(value = "roles")
public class RolesController {
    @Reference(version = "1.0.0")
    private AspnetRolesService aspnetRolesService;

    @ApiOperation(value = " 获取角色名称")
    @ApiImplicitParam(name = "roleName", value = "角色名称", required = false, dataType = "string", paramType = "path")
    @GetMapping(value = "query")
    public ResponseResult<List<RolesNameList>> query(@RequestParam(name = "roleName",required = false) String roleName){
        List<RolesNameList> lists = aspnetRolesService.selectRoleName(roleName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }
}
