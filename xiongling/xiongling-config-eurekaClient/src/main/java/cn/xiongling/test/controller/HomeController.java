package cn.xiongling.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/index")
    public String home() {
        return "<html><body><h1>你好,Hello World</h1></body></html>";
    }
}

