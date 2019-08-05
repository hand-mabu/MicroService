package com.example.consumer_node1.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-producer", fallback = NodeRemoteImp1.class)
public interface NodeRemote1 {
    @RequestMapping(value="/node")
    String hello(@RequestParam(value = "cl") String name);
}
