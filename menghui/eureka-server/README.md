# 注册中心

### pom依赖

```
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

### 启动方式

#### application.properties

```
    spring.profiles.active=dev
```

将spring.profiles.active分别更改为dev,dev2，运行EurekaServerApplication.java