package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrgService;
import com.funtl.myshop.plus.provider.domain.OrgNameList;
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
 * 部门信息
 */
@Api(tags = "部门相关操作")
@RestController
@RequestMapping(value = "org")
public class OrgController {
    @Reference(version = "1.0.0")
    private OrgService orgService;

    @ApiOperation(value = " 获取部门名称")
    @ApiImplicitParam(name = "depName", value = "部门名称", required = false, dataType = "string", paramType = "path")
    @GetMapping(value = "query")
    public ResponseResult<List<OrgNameList>> query(@RequestParam(name = "depName",required = false) String depName){
        List<OrgNameList> lists = orgService.selectOrgName(depName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }
}
