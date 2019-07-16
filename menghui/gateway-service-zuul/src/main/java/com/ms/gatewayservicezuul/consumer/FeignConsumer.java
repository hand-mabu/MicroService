package com.ms.gatewayservicezuul.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 刘梦辉
 * @description
 * @date 2019/7/16
 */
@FeignClient(name = "spring-cloud-producer")
public interface FeignConsumer {
    @RequestMapping(value = "/hello")
    public String hello2(@RequestParam(value = "name") String name);
}
