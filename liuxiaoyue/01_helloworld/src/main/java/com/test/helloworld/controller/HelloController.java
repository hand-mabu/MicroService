package com.test.helloworld.controller;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/helloworld")
    public String HelloWorld(){
        return "Hello World!";
    }
}
