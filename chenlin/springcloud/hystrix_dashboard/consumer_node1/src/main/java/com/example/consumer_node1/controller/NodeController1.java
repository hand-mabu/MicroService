package com.example.consumer_node1.controller;

import com.example.consumer_node1.remote.NodeRemote1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController1 {
    @Autowired
    NodeRemote1 NodeRemote1;
    @RequestMapping("/node/{name}")
    public String index(@PathVariable("name") String name) {
        return NodeRemote1.hello(name);
    }

}
