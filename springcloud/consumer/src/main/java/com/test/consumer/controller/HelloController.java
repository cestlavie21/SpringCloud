package com.test.consumer.controller;

import com.test.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
       return  helloService.sayHello(name);
    }
}
