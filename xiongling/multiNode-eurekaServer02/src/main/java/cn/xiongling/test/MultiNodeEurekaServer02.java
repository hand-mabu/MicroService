package cn.xiongling.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:  高可用Eureka服务注册中心
 * @Author: xiongling
 * @Date: 2019/7/13 00:09
 * Eureka Server的高可用实际上就是将自己做为服务向其他服务注册中心注册自己
 * 只要有一条边将节点连接，就可以进行信息传播与同步。可以采用两两注册的方式实现集群中节点完全对等的效果，实现最高可用性集群，任何一台注册中心故障都不会影响服务的注册与发现
 */
@SpringBootApplication
@EnableEurekaServer
public class MultiNodeEurekaServer02 {

    public static void main(String[] args) {
        SpringApplication.run(MultiNodeEurekaServer02.class, args);
    }
}

