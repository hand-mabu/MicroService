package com.ms.gatewayservicezuul.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 刘梦辉
 * @description
 * @date 2019/7/16
 */
@FeignClient(name = "serviceA")
public interface FeignConsumer {
    @RequestMapping(value = "/User/getUser/{id}")
    String getUser(@PathVariable(value = "id") int id);
}
