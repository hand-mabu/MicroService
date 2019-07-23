package com.sandboat.eurekacustomer02feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaCustomer02FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCustomer02FeignApplication.class, args);
    }
}
