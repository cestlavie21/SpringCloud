package com.test.feignservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    FeginService feginService;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable String name ){
        System.out.println("this is fegin");
        return   feginService.sayHelloByFegin(name);
    }

}
