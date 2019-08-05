package com.spring.eric.ericdemo.controller;

import com.spring.eric.ericdemo.dto.Demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * description: 最简单的demo 演示
 *
 * @date: 2019/7/29
 * @author: @shihai.li@hand-china.com
 **/
// @Controller
@RestController
@RequestMapping(value = "/EricJayLsh")
public class EricDemo {

    // 通过value 注解获取配置文件中的值
    @Value(value = "${eric.jay.randomValue}")
    private String randomValue;

    @Value(value = "${eric.jay.randomInt}")
    private int randomInt;

    @Value(value = "${eric.jay.urlValue}")
    private String urlValue;




    @RequestMapping(value = "/demo1")
    public String demo1() {
        return "I WANT TO SEE SPRINGBOOT";
    }

    @RequestMapping(value = "/demo2")
    public Map<String, Object> demo2() {
        Map<String, Object> map = new HashMap();
        map.put("name", "ericjaylsh");
        map.put("song", "七里香");
        map.put("persion", "周杰伦");
        map.put("randomValue", randomValue);
        map.put("randomInt", randomInt);
        map.put("urlValue", urlValue);
        map.put("date", new Date());
        return map;
    }


    @RequestMapping(value = "/demo3/{name}/{age}")
    public Demo demo3(@PathVariable String name, @PathVariable int age) {
        Demo demo = new Demo();
        demo.setAge(age);
        demo.setName(name);
        demo.setDate(new Date());
        return demo;
    }

    @RequestMapping(value = "/demo4")
    public Demo demo4(@RequestParam String name) {
        Demo demo = new Demo();
        demo.setAge(10);
        demo.setName(name);
        demo.setDate(new Date());
        return demo;
    }


}
