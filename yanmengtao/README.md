# MicroService 微服务学习

## Eureka
参考地址：

https://blog.csdn.net/qq_42362099/article/details/80585550

http://blog.didispace.com/categories/Spring-Cloud/page/12/

![img](http://minios.strongsickcat.com:8080/yanmengtao/ee.png)


## 熔断器（CircuitBreaker）
参考地址：
http://blog.didispace.com/springcloud3/

熔断器的原理很简单，如同电力过载保护器。它可以实现快速失败，如果它在一段时间内侦测到许多类似的错误，会强迫其以后的多个调用快速失败，不再访问远程服务器，从而防止应用程序不断地尝试执行可能会失败的操作，使得应用程序继续执行而不用等待修正错误，或者浪费CPU时间去等到长时间的超时产生。熔断器也可以使应用程序能够诊断错误是否已经修正，如果已经修正，应用程序会再次尝试调用操作。

熔断器模式就像是那些容易导致错误的操作的一种代理。这种代理能够记录最近调用发生错误的次数，然后决定使用允许操作继续，或者立即返回错误。 熔断器开关相互转换的逻辑如下图：

##  Netflix Hystrix
在Spring Cloud中使用了Hystrix 来实现断路器的功能。Hystrix是Netflix开源的微服务框架套件之一，该框架目标在于通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。Hystrix具备拥有回退机制和断路器功能的线程和信号隔离，请求缓存和请求打包，以及监控和配置等功能。

Feign使用Hystrix
注意这里说的是“使用”，没有错，我们不需要在Feigh工程中引入Hystix，Feign中已经依赖了Hystrix

## 分布式配置中心
Spring Cloud Config为服务端和客户端提供了分布式系统的外部化配置支持。配置服务器为各应用的所有环境提供了一个中心化的外部配置。它实现了对服务端和客户端对Spring Environment和PropertySource抽象的映射，所以它除了适用于Spring构建的应用程序，也可以在任何其他语言运行的应用程序中使用。作为一个应用可以通过部署管道来进行测试或者投入生产，我们可以分别为这些环境创建配置，并且在需要迁移环境的时候获取对应环境的配置来运行。

## 服务网关
服务网关是微服务架构中一个不可或缺的部分。通过服务网关统一向外系统提供REST API的过程中，除了具备服务路由、均衡负载功能之外，它还具备了权限控制等功能。Spring Cloud Netflix中的Zuul就担任了这样的一个角色，为微服务架构提供了前门保护的作用，同时将权限控制这些较重的非业务逻辑内容迁移到服务路由层面，使得服务集群主体能够具备更高的可复用性和可测试性。

## 其他相关资料
### 非安全端口
- 1,    // tcpmux
- 7,    // echo
- 9,    // discard
- 11,   // systat
- 13,   // daytime
- 15,   // netstat
- 17,   // qotd
- 19,   // chargen
- 20,   // ftp data
- 21,   // ftp access
- 22,   // ssh
- 23,   // telnet
- 25,   // smtp
- 37,   // time
- 42,   // name
- 43,   // nicname
- 53,   // domain
- 77,   // priv-rjs
- 79,   // finger
- 87,   // ttylink
- 95,   // supdup
- 101,  // hostriame
- 102,  // iso-tsap
- 103,  // gppitnp
- 104,  // acr-nema
- 109,  // pop2
- 110,  // pop3
- 111,  // sunrpc
- 113,  // auth
- 115,  // sftp
- 117,  // uucp-path
- 119,  // nntp
- 123,  // NTP
- 135,  // loc-srv /epmap
- 139,  // netbios
- 143,  // imap2
- 179,  // BGP
- 389,  // ldap
- 465,  // smtp+ssl
- 512,  // print / exec
- 513,  // login
- 514,  // shell
- 515,  // printer
- 526,  // tempo
- 530,  // courier
- 531,  // chat
- 532,  // netnews
- 540,  // uucp
- 556,  // remotefs
- 563,  // nntp+ssl
- 587,  // stmp?
- 601,  // ??
- 636,  // ldap+ssl
- 993,  // ldap+ssl
- 995,  // pop3+ssl
- 2049, // nfs
- 3659, // apple-sasl / PasswordServer
- 4045, // lockd
- 6000, // X11
- 6665, // Alternate IRC [Apple addition]
- 6666, // Alternate IRC [Apple addition]
- 6667, // Standard IRC [Apple addition]
- 6668, // Alternate IRC [Apple addition]
- 6669, // Alternate IRC [Apple addition]
