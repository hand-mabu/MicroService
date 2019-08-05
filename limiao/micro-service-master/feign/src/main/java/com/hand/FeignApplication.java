package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 声明式服务调用
 * Feign是一个声明式的REST客户端，它的目的就是让REST调用更加简单。
 *
 * Feign提供了HTTP请求的模板，
 * 通过编写简单的接口和插入注解，就可以定义好HTTP请求的参数、格式、地址等信息。
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FeignApplication {
  public static void main(String[] args) {
	  
    SpringApplication.run(FeignApplication.class, args);
  }
}