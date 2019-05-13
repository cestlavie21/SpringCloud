package com.test.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 从github 配置中读取name
    @Value("${name}")
    private String name;
    @RequestMapping("/hello")
    public  String hello(){
        return  name;
    }
}
