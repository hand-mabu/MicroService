package com.example.consumer_node2.controller;

import com.example.consumer_node2.remote.NodeRemote2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController2 {
    @Autowired
    NodeRemote2 NodeRemote2;
    @RequestMapping("/node/{name}")
    public String index(@PathVariable("name") String name) {
        return NodeRemote2.hello(name);
    }

}
