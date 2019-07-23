package com.example.consumer_dashboard.controller;
import com.example.consumer_dashboard.remote.TestRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @Autowired
    TestRemote TestRemote;
    @RequestMapping("/test/{name}")
    public String index(@PathVariable("name") String name) {
        return TestRemote.test(name);
    }
}
