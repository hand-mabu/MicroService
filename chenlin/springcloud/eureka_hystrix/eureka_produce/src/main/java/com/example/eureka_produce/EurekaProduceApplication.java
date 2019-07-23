package com.example.eureka_produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProduceApplication.class, args);
	}

}
