package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.EmpBaseService;
import com.funtl.myshop.plus.provider.dto.EmpListDto;
import com.funtl.myshop.plus.provider.dto.EmpQueryParam;
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

/**
 * 员工信息
 */
@Api(tags = "员工相关操作")
@RestController
@RequestMapping(value = "emp")
public class EmpBaseController {
    @Reference(version = "1.0.0")
    private EmpBaseService empBaseService;

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


}
