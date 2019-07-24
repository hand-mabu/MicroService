package com.example.hystrix_eureka_consumer.controller;
import com.example.hystrix_eureka_consumer.remote.HystrixRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HystrixConsumerController {
    @Autowired
    HystrixRemote HystrixRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return HystrixRemote.hello(name);
    }
}





