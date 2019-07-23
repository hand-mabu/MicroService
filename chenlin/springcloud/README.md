

# springcloud

## 1.服务中心

##### 服务中心又称注册中心，管理各种服务功能包括服务的注册、发现、熔断、负载、降级等，Eureka由两个组件组成：Eureka服务器和Eureka客户端。Eureka服务器用作服务注册服务器。Eureka客户端是一个java客户端，用来简化与服务器的交互、作为轮询负载均衡器，并提供服务的故障切换支持。Netflix在其生产环境中使用的是另外的客户端，它提供基于流量、资源利用率以及出错状态的加权负载均衡。

图解：![1563873893321](C:\Users\林林\AppData\Roaming\Typora\typora-user-images\1563873893321.png)



> Eureka Server：  启动类添加注解 @EnableEurekaServer （提供服务注册与发现）

> Provide：将自身服务注册到Eureka，添加注解 @EnableDiscoveryClient

> consumer：从Eureka获取注册服务列表，添加注解@EnableDiscoveryClient，@EnableFeignClients

***运行结果：***

![1563874409592](C:\Users\林林\AppData\Roaming\Typora\typora-user-images\1563874409592.png)

## 2.熔断 Hystrix

##### 断路器很好理解, 当Hystrix Command请求后端服务失败数量超过一定比例(默认50%), 断路器会切换到开路状态(Open). 这时所有请求会直接失败而不会发送到后端服务. 断路器保持在开路状态一段时间后(默认5秒), 自动切换到半开路状态(HALF-OPEN). 这时会判断下一次请求的返回情况, 如果请求成功, 断路器切回闭路状态(CLOSED), 否则重新切换到开路状态(OPEN). Hystrix的断路器就像我们家庭电路中的保险丝, 一旦后端服务不可用, 断路器会直接切断请求链, 避免发送大量无效请求影响系统吞吐量, 并且断路器有自我检测并恢复的能力.



图解：![1563874638876](C:\Users\林林\AppData\Roaming\Typora\typora-user-images\1563874638876.png)



> 因为熔断只是作用在服务消费者这一端，所以只需配置consumer即可





- 修改配置文件： 

  ```spring.application.name=spring-cloud-consumer
  server.port=9001
  feign.hystrix.enabled=true
  eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/
  ```

- 添加fallback属性 

  ```java
  
  @FeignClient(name= "spring-cloud-producer",fallback = HelloRemoteHystrix.class)
  public  interface   HystrixRemote {
      @RequestMapping(value = "/hello")
       public String hello(@RequestParam(value = "name") String name);
  }
  ```

  ***运行结果***：

  ![1563875609329](C:\Users\林林\AppData\Roaming\Typora\typora-user-images\1563875609329.png)

  

  ![1563875624044](C:\Users\林林\AppData\Roaming\Typora\typora-user-images\1563875624044.png)

  ## 3.熔断监控 Dashboard

  ##### Hystrix-dashboard是一款针对Hystrix进行实时监控的工具，通过Hystrix Dashboard我们可以在直观地看到各Hystrix Command的请求响应时间, 请求成功率等数据。

  > 修改服务调用端启动类的配置，增加dashboard注解

  ```java
  @SpringBootApplication
  @EnableDiscoveryClient
  @EnableFeignClients
  @EnableHystrixDashboard
  @EnableCircuitBreaker
  public class HystrixConsumerDashboardApplication {
      public static void main(String[] args) {
          SpringApplication.run(HystrixConsumerDashboardApplication.class, args);
      }
  }
  ```

  ```
  //修改application.properties
  spring.application.name=spring-cloud-consumer
  server.port=9001
  feign.hystrix.enabled=true
  eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/
  ```

  ***运行结果：***

  ![1563876430068](C:\Users\林林\AppData\Roaming\Typora\typora-user-images\1563876430068.png)

  ![1563876471145](C:\Users\林林\AppData\Roaming\Typora\typora-user-images\1563876471145.png)

  ![1563876540253](C:\Users\林林\AppData\Roaming\Typora\typora-user-images\1563876540253.png)

  ## 4. zuul

  

  

  

  

  

  





