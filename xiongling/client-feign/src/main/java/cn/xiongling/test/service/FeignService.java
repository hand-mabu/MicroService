package cn.xiongling.test.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "EUREKA-CLIENT")
public interface FeignService {

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String printMessage();

}
