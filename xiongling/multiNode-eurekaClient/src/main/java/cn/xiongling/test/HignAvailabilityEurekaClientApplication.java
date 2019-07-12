package cn.xiongling.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:  高可用Eureka-服务提供者
 * @Author: xiongling
 * @Date: 2019/7/12 23:01
 */
@SpringBootApplication
//注册成为Eureka客户端
@EnableDiscoveryClient
public class HignAvailabilityEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HignAvailabilityEurekaClientApplication.class, args);
    }
}
