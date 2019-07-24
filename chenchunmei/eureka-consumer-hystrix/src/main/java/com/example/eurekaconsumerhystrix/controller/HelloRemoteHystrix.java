package com.example.ribbonconsumer.controller;

import com.example.ribbonconsumer.service.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: sybil
 * @Email: chunmei.chen@hand-china.com
 * @Description:
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String index(@RequestParam(value = "name") String name) {
        return "hello " + name + ", 嗯，消息发送失败";
    }
}
