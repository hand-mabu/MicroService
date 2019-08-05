package com.example.consumer_node2.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name= "spring-cloud-producer", fallback = NodeRemoteImp2.class)
public interface NodeRemote2 {
    @RequestMapping("/node/{name}")
    String hello (@RequestParam(value = "cl") String name);
}
