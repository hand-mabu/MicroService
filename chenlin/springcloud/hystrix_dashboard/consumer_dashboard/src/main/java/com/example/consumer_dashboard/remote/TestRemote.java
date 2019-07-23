package com.example.consumer_dashboard.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-producer", fallback = TestRemoteHystrix.class)
public interface TestRemote {
    @RequestMapping(value = "/test")
    public String test(@RequestParam(value = "name") String name);
}
