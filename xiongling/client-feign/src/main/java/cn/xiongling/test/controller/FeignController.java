package cn.xiongling.test.controller;

import cn.xiongling.test.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String printMessage() {
        return feignService.printMessage();
    }
}
