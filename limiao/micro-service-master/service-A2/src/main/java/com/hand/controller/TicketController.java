package com.hand.controller;

import com.hand.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping("/ticket")
    public String getTicket(){
        System.out.println("8002");
        return service.getTicket();
    }
}
