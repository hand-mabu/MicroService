package com.example.hystrix_eureka_consumer.remote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
@Component
public class HelloRemoteHystrix implements HystrixRemote{
    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello " +name+ " this is HelloRemoteHystrix,这条消息发送失败！熔断成功！";
    }
}
