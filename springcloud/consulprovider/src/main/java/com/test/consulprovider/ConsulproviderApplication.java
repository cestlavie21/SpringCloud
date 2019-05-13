package com.test.consulprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * consul 测试
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulproviderApplication.class, args);
    }

}
