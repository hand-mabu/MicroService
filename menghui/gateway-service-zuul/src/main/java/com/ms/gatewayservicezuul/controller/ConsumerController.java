package com.ms.gatewayservicezuul.controller;

import com.ms.gatewayservicezuul.consumer.FeignConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘梦辉
 * @date 2019/7/15
 */
@RestController
public class ConsumerController {

    @Autowired
    FeignConsumer feignConsumer;

    @RequestMapping("/hello")
    public String index(@RequestParam("name") String name) {
        return feignConsumer.hello2(name);
    }
}
