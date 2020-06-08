package com.funtl.myshop.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.funtl.myshop.plus.provider.mapper")
public class ProviderTableApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderTableApplication.class,args);
    }
}
