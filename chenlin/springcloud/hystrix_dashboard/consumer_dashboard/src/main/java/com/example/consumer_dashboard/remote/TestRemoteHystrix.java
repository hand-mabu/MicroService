package com.example.consumer_dashboard.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class TestRemoteHystrix implements TestRemote{
    @Override
    public String test(@RequestParam(value = "name") String name) {
        return "测试 " +name+",消息发送失败，熔断成功!";
    }
}
