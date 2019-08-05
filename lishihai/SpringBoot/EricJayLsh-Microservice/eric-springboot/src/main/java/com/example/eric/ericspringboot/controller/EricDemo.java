package com.example.eric.ericspringboot.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/springboot")
public class EricDemo {


    // 通过value 注解获取配置文件中的值
    @Value(value = "${eric.jay.randomValue}")
    private String randomValue;

    @Value(value = "${eric.jay.randomInt}")
    private int randomInt;

    @Value(value = "${eric.jay.urlValue}")
    private String urlValue;


    @RequestMapping(value = "/test1")
    public Map<String, Object> test1() {
        Map<String, Object> map = new HashMap();
        map.put("randomValue", randomValue);
        map.put("randomInt", randomInt);
        map.put("urlValue", urlValue);
        map.put("date", new Date());
        return map;
    }

}
