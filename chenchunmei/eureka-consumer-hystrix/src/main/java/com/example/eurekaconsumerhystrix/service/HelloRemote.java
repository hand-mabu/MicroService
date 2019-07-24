package com.example.ribbonconsumer.service;

import com.example.ribbonconsumer.controller.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: sybil
 * @Email: chunmei.chen@hand-china.com
 * @Description:
 * name 远程服务名称；
 * fallback  服务熔断时返回fallback类中的内容
 */
@FeignClient(name = "eureka-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping(value = "/hello")
    String index(@RequestParam(value = "name") String name);
}
