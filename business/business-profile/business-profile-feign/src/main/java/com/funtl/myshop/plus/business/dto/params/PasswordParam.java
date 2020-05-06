package com.funtl.myshop.plus.business.dto.params;

import lombok.Data;

/**
 * 修改密码参数
 */

@Data
public class PasswordParam {
    private String username;
    private String oldPassword;
    private String newPassword;
}
