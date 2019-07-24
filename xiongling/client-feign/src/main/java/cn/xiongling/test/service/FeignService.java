package cn.xiongling.test.service;

import cn.xiongling.test.controller.MessageServiceFailure;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "EUREKA-CLIENT", fallback = MessageServiceFailure.class)
public interface FeignService {

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String printMessage();

}
