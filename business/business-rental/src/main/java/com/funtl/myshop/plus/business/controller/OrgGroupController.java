package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrgGroupService;
import com.funtl.myshop.plus.provider.domain.OrgGroupNameList;
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
 * 所属组信息
 */
@Api(tags = "所属组相关操作")
@RestController
@RequestMapping(value = "group")
public class OrgGroupController{
    @Reference(version = "1.0.0")
    private OrgGroupService orgGroupService;


}
