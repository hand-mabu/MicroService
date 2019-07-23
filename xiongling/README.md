# 微服务学习
### eureka服务注册中心（单机模式）
   > 搭建单机spring boot eureka服务注册中心项目，参见以下地址
    
   - [搭建单机eureka服务注册中心项目](https://blog.csdn.net/qq_28143647/article/details/79473294)
   
   - 搭建EurekaServer模块（服务端）
   
        >在服务注册时，需要确认以下参数的值，true启动注册操作，false不启动注册操作。
        ```
        eureka.client.register-with-eureka=true
        ```
   
   - 搭建EurekaClient模块（客户端）
   
     将客户端项目注册至服务端，通过指定ServiceUrl将服务注册到一个有效的主机上
     ```
     eureka:
         client:
            serviceUrl:
                defaultZone: http://localhost:8080/eureka/
     ```

### eureka服务注册中心（集群模式）
   > 搭建多节点spring boot eureka服务注册中心项目，参见以下地址
   
   - [搭建集群eureka服务注册中心项目](https://blog.csdn.net/qq_28143647/article/details/79473294)
   
   - 搭建EurekaServer01、EurekaServer02、EurekaServer03
   
   - 搭建EurekaClient
### config server和client的搭建

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   ***建议了解掌握bootstrap.yml和application.yml两个文件的区别***  
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   config-server 中使用 ***application.yml***  
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   config-client 中使用 ***bootstrap.yml***
       
    
### Eureka基础架构 & 通信机制
   - Eureka服务配置与进阶  
        参考链接：[Eureka服务配置与进阶](https://www.cnblogs.com/sky-chen/p/10764931.html)
   
   - 服务注册中心

        Eureka Server，用于提供服务注册，即发现应用的功能。  
       1. 失效剔除  
            对于服务实例非正常下线、内存溢出、网络故障等原因使服务不能正常工作，服务注册中心未收到“服务下线”请求。
            Eureka Server在启动的时候会创建一个定时任务，默认每隔一段时间（默认60s）
            将当前清单中超时（默认为90s）没有续约的服务剔除出去。
            
       2. 自我保护  
            enableSelfPreservation默认true，启用注册中心的自保护机制，
            Eureka如果统计到15分钟之内损失>15%的微服务心跳，则会触发自保护机制，不再提出服务提供者。
            本地开发时，使用以下参数来关闭保护机制，确保注册中心可以将不可用的实例正确删除：
            ```
                eureka:
                    server:
                        enable-self-preservation: false             
            ```      
        
   - 服务提供者
   
        提供服务的应用。spring boot应用或其他技术平台遵循Eureka通信机制的应用
        1. 服务注册  
          服务提供者携带自身服务的一些元数据通过REST请求将自己注册到EurekaServer上
        2. 服务同步  
          两台注册中心相互注册为服务，每台注册中心分别注册维护一个服务，由于两台注册中心相互注册，分别注册服务时，每个服务会同步转发至集群中相连的注册中心，从而实现注册中心之间的服务同步。
        3. 服务续约  
           服务注册完成之后，服务提供者会维持一个心跳告诉EurekaServer：“我还活着”，以防止Eureka Server的”剔除任务“将该服务实例从服务列表中排除出去。此操作称为服务续约。（Renew）  
           通过以下属性来调整续约：
           ```
            eureka:
                instance:
                    lease-renewal-interval-in-seconds: 30
                    lease-expiration-duration-in-seconds: 90
           ```
          
   - 服务消费者
   
        消费者应用从注册中心获取应用列表，使其清楚自己从何处调用所需要的服务。重点了解***Ribbon***负载均衡工具和***Feign***微服务调用工具两种消费模式
        1. 获取服务
            确保bootstrap.yml配置文件中的以下字段设置为true
            ```
            eureka:
                client:
                    fetch-registry: true
                    # 设置缓存清单（服务清单）更新时间
                    registry-fetch-interval-seconds: 30
            ```    
        2. 服务调用
            获取到服务清单后，通过服务名获取提供服务的实例名和该实例的元数据信息，客户端可根据自己需要决定调用哪个实例
            Ribbon：默认采用***轮询***方式调用，使客户端负载均衡
            Eureka中提供Region和Zone的概念进行分区，一个Region可以包含多个Zone。例如：
            ```
                eureka:
                    client:
                        fetch-registry: true
                        # true：跟着availability-zones中的zone走
                        # false：跟着service-url走，按zone1注册，注册失败按zone2注册，重试3次
                        prefer-same-zone-eureka: true
                        region: sicuan
                        availability-zones:
                            beijing: zone-1,zone-2
                        service-url:
                            zone-1: http://localhost:8080/eureka/
                            zone-2: http://localhost:8081/eureka/
            ```
            服务调用的配置文件：
            ```
                eureka:
                  instance:
                    metadata-map:
                      zone: zone-1
            ```
            服务消费者和服务提供者分别属于哪个zone，均通过此字段来判定。
            服务消费者会先通过ribbon去注册中心拉取一份服务提供者的列表，通过此字段指定的zone进行过滤，过滤之后如果同一个zone内的服务提供者有多个实例，则会轮流调用。
            只有在同一个zone内的所有服务提供者都不可用时，才会调用其它zone内的服务提供者。
        3. 服务下线
        
            对于服务实例的关闭或重启，在服务关闭重启期间，需要将此状态告诉给服务注册中心，将服务状态置为down，并把下线事件传播出去
### Actuator监控中心
   > ```spring-boot-starter-actuator```：用于监控与管理。参考配置Actuator资料：[spring boot 1.5.2 监控Actuator](https://blog.51cto.com/wyait/1970021?utm_source=oschina-app)
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
### 负载均衡 —— Ribbon组件
   服务器端负载均衡：硬件/软件负载均衡。nginx（软件负载均衡，在用户服务前添加nginx）  
   客户端负载均衡：Ribbon + restful 和 feign
   
   - Ribbon策略  
    （1）轮询（RoundRobin）
    （2）随机（Random）
    （3）加权（Weighted）
    （4）哈希（Hash）
    （5）一致性哈希（ConsistentHash）
    
   
   - Ribbon的工作步骤  
    （1）服务提供者启动多个服务实例并注册到一个注册中心，或多个相关联的服务注册中心  
    （2）服务消费者直接通过被```@LoadBalanced```注解修饰过的RestTemplate来实现面向服务的接口调用    
        ![img](https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3322634002,818951745&fm=173&app=49&f=JPEG?w=640&h=323&s=5E283C63CB626C0B4A7D51CA000080B1)
   
   - 实例  
    （1）在项目中引入Robbin  
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        由于```spring-cloud-starter-eureka```依赖已经包含了Robbin，所以无需重新添加jar包
        ```
        <!--EurekaClient客户端依赖-->
        <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-eureka</artifactId>
           <version>1.3.6.RELEASE</version>
        </dependency>
        ```
     （2）添加 ```@LoadBalanced``` 注解即可
     （3）注意调用restful的```restTemplate.getForObject```方法时，引用的服务是```spring.application.name```的值
     
 ## Feign声明式服务调度方式
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   Feign是Spring Cloud提供的一种声明式REST客户端  
   - Feign的实现方式  
        （1）在pom文件引入相应的依赖
        ```$xslt
            <!-- 声明式REST客户端，访问调用远程服务提供的REST接口 -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-feign</artifactId>
            </dependency>
        ```
        
        （2）在service层使用注解```@FeignClient```声明服务，注意，此处声明的同样是```spring.application.name```的值  
        
            @FeignClient(value = "EUREKA-CLIENT")
        （3）在controller层调用service层的接口即可
        
## 熔断机制--断路器（Hystrix）
   ![img](https://images2017.cnblogs.com/blog/1027173/201708/1027173-20170803150500756-1303484805.png)
   - Hystrix断路器库的添加方式  
        （1）添加依赖
        ```$xslt
            <!-- Hystrix断路器依赖 -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-hystrix</artifactId>
            </dependency>
        ```
        （2）在Ribbon中使用断路器  
            &nbsp;&nbsp;&nbsp;&nbsp;
            在启动类上添加```@EnableCircuitBreaker```注解
            在service层添加```@HystrixCommand```注解，标注访问服务的方法，代码如下
            
            // @HystrixCommand注解标注访问服务的方法
            @HystrixCommand(fallbackMethod = "serviceFailure")
            public String getMessageContent() {
               return restTemplate.getForObject("http://EUREKA-CLIENT/message", String.class);
            }
            
            public String serviceFailure() {
               return "The current service is not available";
            }
              
        （3）在Feign中使用断路器  
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            注意：Feign内部支持了断路器，无需再在启动类上添加额外注解  
            用```@FeignClient```注解添加fallback类，如下：  
            ```@FeignClient(name = "EUREKA-CLIENT", fallback = MessageServiceFailure.class)```  
            最后，创建服务调用异常失败类，继承此接口，代码如下：  
            
            @Component
            public class MessageServiceFailure implements FeignService {
            
                @Override
                public String printMessage() {
                    return "The current service is not available";
                }
            }
## 路由网关zuul
  > zuul：路由和过滤。zuul实现了负载均衡
  
   ![img](https://images2017.cnblogs.com/blog/1027173/201708/1027173-20170807163318987-1931843559.png)
   - 创建zuul服务  
        （1）添加依赖
   
         <!-- zuul依赖 -->
         <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zuul</artifactId>
         </dependency>
            
        （2）在启动类顶部添加注解```@EnableZuulProxy```  
        （3）添加配置文件，添加路由
        
            zuul:
              routes:
                ribbo:
                  path: /api-ribbon/**
                  serviceId: client-ribbon
                feign:
                  path: /api-feign/**
                  serviceId: service-feign  
        （4）zuul过滤器  
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        实现ZuulFilter接口接口对请求先进性筛选和过滤之后再路由到服务器  
        
学习参考博客：[spring cloud微服务入门教程](https://www.cnblogs.com/chry/p/7248947.html)
   