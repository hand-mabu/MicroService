package com.ms.eurekaclient2.feign.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 刘梦辉
 * @date 2019/7/15
 */
@FeignClient(name= "spring-cloud-producer")
public interface FeignConsumer {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
