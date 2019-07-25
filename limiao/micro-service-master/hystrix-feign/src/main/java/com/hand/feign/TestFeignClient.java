package com.hand.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hand.feign.TestFeignClient.HystrixClientFallback;


@FeignClient(name = "PROVIDER-TICKET",fallback = HystrixClientFallback.class)
public interface TestFeignClient {

   @RequestMapping("/ticket")
   String getTicket();

  @Component
  class HystrixClientFallback implements TestFeignClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

	@Override
	public String getTicket() {
		HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法");
		return "feign-hystrix";
	}
  }
}