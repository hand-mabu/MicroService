package cn.xiongling.test.controller;

import cn.xiongling.test.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired private MessageService messageService;

//    @Autowired
//    public MessageController(MessageService messageService) {
//        this.messageService = messageService;
//    }

    @RequestMapping(value = "/message")
    public String hi(){
        return messageService.hiService();
    }

}
