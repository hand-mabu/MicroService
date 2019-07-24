package com.example.ribbonconsumer.controller;

import com.example.ribbonconsumer.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sybil
 * @Email: chunmei.chen@hand-china.com
 * @Description:
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.index(name);
    }


}
