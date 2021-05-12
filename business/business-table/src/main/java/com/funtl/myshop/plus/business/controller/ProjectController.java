package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.provider.api.OrdersService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "张梦燕所需报表")
@RestController
@RequestMapping(value = "tableFour")
public class ProjectController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;



}
