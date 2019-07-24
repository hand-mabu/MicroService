package com.example.zuuleureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuuleurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuuleurekaApplication.class, args);
    }

}
