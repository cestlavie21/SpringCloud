# SpringCloudDemo
springcloud test

# 1. Eureka 组件
一个类似于zookeeper的服务注册与发现的组件
# 搭建步骤
 1.新建一个springboot工程,pom文件引入eureka
      
      <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        
 2.application启动类上开启注解@EnableEurekaServer
 
 ![](https://github.com/cestlavie21/imageRepository/blob/master/images/springCloudImages/eureka-server1.png)

 3.修改application.yml配置文件
 
 ![](https://github.com/cestlavie21/imageRepository/blob/master/images/springCloudImages/eureka-server2.png)
 
 4.启动服务,并在浏览器上查看管理界面  localhost:8000
 
 ![](https://github.com/cestlavie21/imageRepository/blob/master/images/springCloudImages/eureka-server3.png)
