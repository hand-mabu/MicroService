# 微服务学习

### eureka服务注册中心（单机模式）

   > 搭建单机spring boot eureka服务注册中心项目，参见以下地址
    
   - [搭建单机eureka服务注册中心项目](https://blog.csdn.net/qq_28143647/article/details/79473294)
   
   - 搭建EurekaServer模块（服务端）
   
   - 搭建EurekaClient模块（客户端）
   
     将客户端项目注册至服务端

### eureka服务注册中心（集群模式）
   > 搭建多节点spring boot eureka服务注册中心项目，参见以下地址
   
   - [搭建集群eureka服务注册中心项目](https://blog.csdn.net/qq_28143647/article/details/79473294)
   
   - 搭建EurekaServer01、EurekaServer02、EurekaServer03
   
   - 搭建EurekaClient
   
### Actuator监控中心
   spring-boot-starter-actuator：用于监控与管理
   本项目采用的spring boot版本为1.5.2，参考配置Actuator资料：[spring boot 1.5.2 监控Actuator](https://blog.51cto.com/wyait/1970021?utm_source=oschina-app)
   1. 在相应的pom文件中引入依赖
        ```
        <dependency>
   
           <!--引入spring bootactuator监控 -->
   
           <groupId>org.springframework.boot</groupId>
   
           <artifactId>spring-boot-starter-actuator</artifactId>
   
         </dependency>
        ```
   2. Actuator默认可访问health、info，若想查看其他信息，则需要做相应的扩展与配置
        直接访问 http://localhost:1112/autoconfig 不会生效，必须要关闭安全认证才能查看
        ```
        management: 
            security: 
                enabled: false
        ```
        ![img](https://s5.51cto.com/wyfs02/M00/07/C5/wKiom1nPUQKRRM0cAACQVsG7AC0839.png)
   3. 若需要关闭某端点，可以在bootstrap.yml中做如下配置。
        例如：关闭configprops端点
        ```
        endpoints:
            configprops:
                enabled: false
        ```
 ###部署spring boot
    1. 
    2.
    3. 

