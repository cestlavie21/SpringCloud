package com.test.consulconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "consul-provider")
public interface HelloService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String helllo();
}

