package cn.xiongling.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServer {


    @Autowired
    private RestTemplate restTemplate;

    public String getHelloContent() {
        return restTemplate.getForObject("http://SERVICE-HELLOWOELD/",String.class);
    }
}
