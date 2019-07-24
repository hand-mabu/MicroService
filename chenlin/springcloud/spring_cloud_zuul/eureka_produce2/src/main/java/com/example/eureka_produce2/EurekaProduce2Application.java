package com.example.eureka_produce2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProduce2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProduce2Application.class, args);
	}

}
