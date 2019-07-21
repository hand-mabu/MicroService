package com.ms.eurekaclient2.feign.consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 刘梦辉
 * @date 2019/7/16
 */
@Component
public class FeignConsumerHystrix implements FeignConsumer {

    @Override
    public String getUser(@PathVariable int id) {
        return "the method of getUser call failed!";
    }
}