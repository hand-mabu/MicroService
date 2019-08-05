package com.hand.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "声明式接口调用")
@RestController
public class FeignController {
  @Autowired
  private TestFeignClient testFeignClient;

  @ApiOperation(value = "获取票据" ,  notes="获取票据")
  @RequestMapping(value = "/get" , method = RequestMethod.GET)
  public String get() {
    return testFeignClient.getTicket();
  }
}