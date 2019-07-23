package com.example.consumer_node1.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class NodeRemoteImp1 implements NodeRemote1 {
    @Override
    public String hello(@RequestParam(value = "name") String name){
        return "hello ,this is node 1 (consumer)";
    }

}
