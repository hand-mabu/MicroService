package com.spring.eric.ericdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 启动类
 *
 * @SpringBootApplication = (默认属性)@Configuration + @EnableAutoConfiguration + @ComponentScan
 * @Configuration：提到@Configuration就要提到他的搭档@Bean。使用这两个注解就可以创建一个简单的spring配置类，可以用来替代相应的xml配置文件。
 * @Configuration的注解类标识这个类可以使用Spring IoC容器作为bean定义的来源。@Bean注解告诉Spring，一个带有@Bean的注解方法将返回一个对象，该对象应该被注册为在Spring应用程序上下文中的bean。
 * <p>
 * 2、@EnableAutoConfiguration：能够自动配置spring的上下文，试图猜测和配置你想要的bean类，通常会自动根据你的类路径和你的bean定义自动配置。
 * <p>
 * 3、@ComponentScan：会自动扫描指定包下的全部标有@Component的类，并注册成bean，当然包括@Component下的子注解@Service,@Repository,@Controller
 * <p>
 * 这就建议你把使用@SpringBootApplication注解的类放置在root package(官方表述)下，其他类都置在root package的子包里面，这样bean就不会被漏扫描．'
 * <p>
 * <p>
 * <p>
 * 打包：
 * mvn clean package
 * <p>
 * 项目根目录下执行
 * mvn spring-boot:run
 * <p>
 * mvn clean  install
 * @date: 2019/7/29
 * @author: @shihai.li@hand-china.com
 **/
@SpringBootApplication
public class EricDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EricDemoApplication.class, args);
    }

}
