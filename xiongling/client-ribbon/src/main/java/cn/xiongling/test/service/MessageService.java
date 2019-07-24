package cn.xiongling.test.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

    @Autowired private RestTemplate restTemplate;

    // @HystrixCommand注解标注访问服务的方法
    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String getMessageContent() {
        return restTemplate.getForObject("http://EUREKA-CLIENT/message", String.class);
    }

    public String serviceFailure() {
        return "The current service is not available";
    }
}
