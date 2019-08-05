package com.hand.controller;

import com.hand.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "获取票据接口")
@RestController
public class TicketController {

    @Autowired
    private TicketService service;

    @ApiOperation(value = "获取票据" ,  notes="获取票据")
    @GetMapping("/ticket")
    public String getTicket(){
        System.out.println("8001");
        return service.getTicket();
    }
}
