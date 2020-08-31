package com.funtl.myshop.plus.business.feign;

import com.funtl.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "business-profile",path = "consumer",configuration = FeignRequestConfiguration.class)
public interface ConsumerFeign {
    /**
     * 获取个人信息
     * @param username
     * @return
     */
    @GetMapping(value = "infos/{username}")
    String infos(@PathVariable String username);
}
