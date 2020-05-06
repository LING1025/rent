package com.funtl.myshop.plus.business.feign;

import com.funtl.myshop.plus.business.dto.params.ProfileParam;
import com.funtl.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 个人信息管理
 */

@FeignClient(value = "business-profile",path = "profile",configuration = FeignRequestConfiguration.class)
public interface ProfileFeign {
    /**
     * 获取个人信息
     * @param username
     * @return
     */
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);

    /**
     * 更新个人信息
     * @param profileParam
     * @return
     */
    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);
}
