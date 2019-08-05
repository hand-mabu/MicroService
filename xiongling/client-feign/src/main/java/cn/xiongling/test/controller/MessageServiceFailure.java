package cn.xiongling.test.controller;

import cn.xiongling.test.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceFailure implements FeignService {

    @Override
    public String printMessage() {
        return "The current service is not available";
    }
}
