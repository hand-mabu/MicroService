package com.ms.gatewayservicezuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class GatewayServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceZuulApplication.class, args);
    }

}
