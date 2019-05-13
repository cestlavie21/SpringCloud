package com.test.consulprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//开启动态刷新配置
@RefreshScope
public class HelloController {

    @Value("${server.port}")
    private  String port;

    @Value("${foo.bar}")
    private String bar;


    @RequestMapping("/hello")
    public String hello(){
        return "端口"+port;
    }

    @RequestMapping("/bar")
    public String getBar() {
        return "bar:" + bar;
    }


}
