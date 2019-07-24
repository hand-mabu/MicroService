package com.ms.service.controller;

import com.ms.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private IUserService userService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("getUser/{id}")
    public String getUser(@PathVariable int id) {
        return "服务端口" + port + "被调用：" + userService.getUser(id).toString();
    }
}