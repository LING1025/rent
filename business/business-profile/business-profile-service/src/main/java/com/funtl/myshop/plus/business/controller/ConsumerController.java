package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.UserDTO;
import com.funtl.myshop.plus.business.dto.UsersDto;
import com.funtl.myshop.plus.business.dto.params.PasswordParam;
import com.funtl.myshop.plus.business.dto.params.ProfileParam;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.funtl.myshop.plus.provider.domain.User;
import com.funtl.myshop.plus.provider.dto.UserListDto;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息管理
 */

@Api(tags = "用户信息管理相关操作")
@RestController
@RequestMapping(value = "consumer")
public class ConsumerController {
    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @ApiOperation(value = "获取个人信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "path")
    @GetMapping(value = "info/{username}")
    public ResponseResult<UsersDto> info(@PathVariable String username){
        AspnetUsers aspnetUsers = aspnetUsersService.get(username);
        UsersDto usersDto = new UsersDto();
        BeanUtils.copyProperties(aspnetUsers,usersDto);
        if(aspnetUsers == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"用户不存在",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"获取个人信息",usersDto);
    }

    @ApiOperation(value = "更新个人信息")
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody ProfileParam profileParam) {
        AspnetUsers newUmsAdmin = new AspnetUsers();
        BeanUtils.copyProperties(profileParam, newUmsAdmin);
        Integer result = aspnetUsersService.updateUser(newUmsAdmin);

        // 成功
        if (result > 0) {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "更新个人信息成功");
        }

        // 失败
        else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "更新个人信息失败");
        }
    }

    @ApiOperation(value = "修改密码")
    @PostMapping(value = "modify/password")
    public ResponseResult<Void> modifyPassword(@RequestBody PasswordParam passwordParam) {
        AspnetUsers aspnetUsers = aspnetUsersService.get(passwordParam.getUsername());

        // 旧密码正确
        if (passwordEncoder.matches(passwordParam.getOldPassword(), aspnetUsers.getPassword())) {
            Integer result = aspnetUsersService.modifyPassword(aspnetUsers.getUsername(), passwordParam.getNewPassword());
            if (result > 0) {
                return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "修改密码成功");
            }
        }

        // 旧密码错误
        else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "旧密码不匹配，请重试");
        }

        return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "修改密码失败");
    }

    @ApiOperation(value = "获取员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = false, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "isOn", value = "状态", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "query")
    public ResponseResult<PageInfo<UserListDto>> query(@RequestParam(name = "username", required = false) String username,
                                                       @RequestParam(name = "isOn", required = false) Integer isOn,
                                                       @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                       @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {

        return null;
    }


}
