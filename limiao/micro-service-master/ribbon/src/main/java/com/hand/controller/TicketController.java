package com.hand.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@Api(description = "买票接口")
@RestController
public class TicketController {

    @Autowired
    private RestTemplate restTemplate;

//    @ApiOperation(value = "买票" ,  notes="买票")
//    @ApiImplicitParam(name = "name",required = true,value = "查询条件",dataType = "String")
    @GetMapping("/buy")
    public String buyTicket(String name){
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket",String.class);
        return name+"想买"+ s +"这场电影，听说最近很火！";
    }
}
