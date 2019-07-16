package com.ms.eurekaclient3.consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 刘梦辉
 * @date 2019/7/16
 */
@Component
public class FeignConsumerHystrix implements FeignConsumer {

    @Override
    public String hello2(@RequestParam(value = "name") String name) {
        return "hello " + name + ", this messge send failed ";
    }
}