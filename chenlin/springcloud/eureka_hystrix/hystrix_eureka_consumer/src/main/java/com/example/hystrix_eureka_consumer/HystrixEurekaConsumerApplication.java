package com.example.hystrix_eureka_consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class HystrixEurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixEurekaConsumerApplication.class, args);
	}

}
