package com.hand;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import com.hand.filter.ErrorFilter;
import com.hand.filter.ResultFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}

	
//	@Bean
//	public ResultFilter resultFilter() {
//		return new ResultFilter();
//	}
//
//
//	@Bean
//	public ErrorFilter errorFilter() {
//		return new ErrorFilter();
//	}

}
