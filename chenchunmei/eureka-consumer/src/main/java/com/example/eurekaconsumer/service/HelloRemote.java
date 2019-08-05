package com.example.ribbonconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: sybil
 * @Email: chunmei.chen@hand-china.com
 * @Description:
 */
@FeignClient(name = "eureka-producer")
public interface HelloRemote {
    @RequestMapping(value = "/hello")
    String index(@RequestParam(value = "name") String name);
}
