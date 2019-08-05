package com.hand.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PROVIDER-TICKET")
public interface TestFeignClient {
	
  @RequestMapping("/ticket")
  String getTicket();
}