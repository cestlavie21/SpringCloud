package com.test.zuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulserviceApplication.class, args);
    }

}
