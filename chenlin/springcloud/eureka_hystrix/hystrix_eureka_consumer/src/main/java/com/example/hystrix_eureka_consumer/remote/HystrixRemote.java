package com.example.hystrix_eureka_consumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-producer",fallback = HelloRemoteHystrix.class)
public  interface   HystrixRemote {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);

}
