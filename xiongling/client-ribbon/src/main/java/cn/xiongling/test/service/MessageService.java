package cn.xiongling.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

    @Autowired private RestTemplate restTemplate;

    public String hiService() {
        return this.restTemplate.getForObject("http://EUREKA-CLIENT/message", String.class);
    }
}
