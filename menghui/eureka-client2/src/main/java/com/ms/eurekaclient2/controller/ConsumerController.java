package com.ms.eurekaclient2.controller;

import com.ms.eurekaclient2.feign.consumer.FeignConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘梦辉
 * @date 2019/7/15
 */
@RestController
public class ConsumerController {

    @Autowired
    FeignConsumer feignConsumer;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return feignConsumer.hello(name);
    }
}
