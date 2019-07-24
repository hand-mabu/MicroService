package com.example.eureka_producer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProducer1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProducer1Application.class, args);
	}

}
