package com.test.feignservice;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
/**
 *  熔断器实现类
 */
public class FeginServiceHystic  implements  FeginService{
    @Override
    public String sayHelloByFegin(String name) {
        return "sorry"+name;
    }
}
