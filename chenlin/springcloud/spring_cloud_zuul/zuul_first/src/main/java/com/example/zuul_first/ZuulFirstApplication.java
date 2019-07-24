package com.example.zuul_first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulFirstApplication.class, args);
	}

}
