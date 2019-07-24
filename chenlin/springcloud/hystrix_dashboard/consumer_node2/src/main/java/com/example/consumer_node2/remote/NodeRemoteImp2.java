package com.example.consumer_node2.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class NodeRemoteImp2 implements NodeRemote2{
    @Override
    public String hello(@RequestParam(value = "cl") String name) {
        return "this is node2!(consumer)";
    }
}
