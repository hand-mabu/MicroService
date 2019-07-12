package cn.xiongling.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/index")
    public String home() {
        return "<h1>我是熊令，我明天要回成都了哟！！！</h1>";
    }
}
