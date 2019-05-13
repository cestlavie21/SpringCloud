package com.test.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-provider",fallback = FeginServiceHystic.class)
public interface FeginService {
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
     String  sayHelloByFegin(@PathVariable String name);

}
