spring-cloud 微服务组件
===

<table>
<tbody><tr>
<td>工程名</td>  <td>描述</td>  <td>端口</td>
</tr>
<tr>
<td>eureka-server</td>  <td>服务发现与注册中心</td>  <td>7070</td>
</tr>
<tr>
<td>ribbon</td>  <td>负载均衡器</td>  <td>7071</td>
</tr>
<tr>
<td>config-server</td>  <td>配置管理中心</td>  <td>7072</td>
</tr>
<tr>
<td>gateway</td>  <td>动态路由器</td>  <td>7073</td>
</tr>
<tr>
<td>service-A</td>  <td>A和A2服务，用来测试服务高可用和服务路由</td>  <td>7074</td>
</tr>
<tr>
<td>service-B</td>  <td>B服务，服务之间调用、整合Mybatis、PageHelper、Redis</td>  <td>7075</td>
</tr>
<tr>
<td>feign</td>  <td>声明式、模板化的HTTP客户端，可用来做负载均衡，较轻量</td>  <td>7078</td>
</tr>
<tr>
<td>hystrix-feign</td>  <td>feign的容错测试</td>  <td>7079</td>
</tr>
</tbody></table>

环境：JDK1.8

```
 <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
  </properties>
```

有关项目启动和配置的说明：

1、最先启动的是eureka-server，并且你需要在整个测试过程中保持它的启动状态，因为它是注册中心，大多数服务必须依赖于它才能实现必要的功能。 <br>
2、如果你想测试配置中心，可以先启动config-server，再启动service-A，按照规则来获取config-server的配置信息。 <br>
3、如果你想测试负载均衡，则需启动ribbon、service-A、service-A2工程，在ribbon中配置自己需要的负载均衡策略<br>
4、如果你想测试路由，则需启动zuul工程，另外需保证service-A、service-A2其中一个或者多个工程处于启动状态，按照zuul工程的配置文件来进行相应的操作。 <br>
5、如果你想测试熔断功能，则需启动feign与hystrix-feign工程。 <br>
