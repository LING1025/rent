package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.UserService;
import com.funtl.myshop.plus.provider.domain.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 用户注册
 */

@RestController
@RequestMapping(value = "reg")
public class RegController {
    @Reference(version = "1.0.0")
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping(value = "")
    public ResponseResult<User> reg(@RequestBody User user) {
        String message = validateReg(user);

        // 通过验证
        if (message == null) {
            int result = userService.insert(user);

            // 注册成功
            if (result > 0) {
                User admin = userService.get(user.getUsername());
                return new ResponseResult<User>(HttpStatus.OK.value(), "用户注册成功", admin);
            }
        }

        return new ResponseResult<User>(HttpStatus.NOT_ACCEPTABLE.value(), message != null ? message : "用户注册失败");
    }

    /**
     * 注册信息验证
     * @param user
     * @return
     */
    private String validateReg(User user) {
        User admin = userService.get(user.getUsername());

        if (admin != null) {
            return "用户名已存在，请重新输入";
        }

        return null;
    }
}
