# MicroService 微服务学习

## 目录结构

1. eureka-client:测试使用
2. eureka-client2:consumerB
3. eureka-client3:consumerA
4. eureka-server:注册中心
5. gateway-service-zuul:网关中心
6. hystrix-dashboard-turbine:monitor监控中心
7. service:springboot应用
8. config-server:测试注册中心使用

#### 说明

对于eureka-client2,已添加zipkin依赖，可进行zipkin 链路检测日志采集中心实验;

对于eureka-client3，可进行hystrix熔断实验。

## 开启服务注册中心

将eureka-server的spring.profiles.active分别更改为dev,dev2，运行EurekaServerApplication.java，
点击[url](http://127.0.0.1:8000/)，出现以下界面，则开启成功！

![image](https://user-images.githubusercontent.com/37039087/61677796-6ae76e00-ad33-11e9-91c6-fe95f07cccda.png)

## 开启服务，注册到eureka

将spring.profiles.active分别更改为dev,dev2，运行ServiceApplication.java
点击[url](http://127.0.0.1:8080/User/getUser/3)，出现以下界面，则注册成功！

![image](https://user-images.githubusercontent.com/37039087/61678032-44760280-ad34-11e9-93df-a0e9a5edb7d5.png)

service8080

![image](https://user-images.githubusercontent.com/37039087/61678011-2c05e800-ad34-11e9-890d-66571d1264df.png)

service8081

![image](https://user-images.githubusercontent.com/37039087/61678017-36c07d00-ad34-11e9-9d9d-13735756b356.png)

## 开启网关中心zuul

运行GatewayServiceZuulApplication.java，启动网关中心，点击[url](http://localhost:8888/testZuul/User/getUser/3)，出现以下界面，证明开启成功！

![image](https://user-images.githubusercontent.com/37039087/61678265-eac20800-ad34-11e9-8d29-9bf1b60d2093.png)

![image](https://user-images.githubusercontent.com/37039087/61678259-e5fd5400-ad34-11e9-9aee-be55ce547699.png)

## 开启service consumer

启动eureka-client2,eureka-client3项目主类，点击[url](http://127.0.0.1:9000/User/getUser/3)，出现以下界面，证明开启成功！

![image](https://github.com/MenghuiLiu/images-folder/blob/master/1.1.png?raw=true)

![image](https://github.com/MenghuiLiu/images-folder/blob/master/1.2.png?raw=true)

![image](https://github.com/MenghuiLiu/images-folder/blob/master/1.3.png?raw=true)

## 开启monitor监控中心

运行HystrixDashboardTurbineApplication.java，点击[url](http://localhost:9050/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9000%2Fhystrix.stream)，出现以下界面，证明开启成功！

![image](https://github.com/MenghuiLiu/images-folder/blob/master/monitor%E7%9B%91%E6%8E%A7%E4%B8%AD%E5%BF%83.png?raw=true)