package com.example.eurekaproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sybil
 * @Email: chunmei.chen@hand-china.com
 * @Date: 2019/7/22 01:15
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        System.out.println("abc");
        return "hello " + name + ", 这是我提供的服务2ya！";
    }
}
