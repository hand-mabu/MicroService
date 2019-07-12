package cn.xiongling.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by xiongling on 2019/07/13 Time:00:40
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServer.class,args);
        System.out.println("EurekaServer begins starting");
    }
}

