# 网关中心zuul

### pom依赖

```
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!--feign-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>
    </dependencies>
```

### 启动方式

#### application.properties

```
    spring.application.name=gateway-service-zuul
    server.port=8888
    
    zuul.routes.serviceA = /testZuul/**
    
    eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/
```

运行GatewayServiceZuulApplication.java，启动网关中心