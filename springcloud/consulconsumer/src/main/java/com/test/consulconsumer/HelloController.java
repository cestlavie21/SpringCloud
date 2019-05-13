package com.test.consulconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public  String hello(){
       return helloService.helllo();
    }

    @RequestMapping("/123")
    public  String hi(){
        return "1111";
    }
}
