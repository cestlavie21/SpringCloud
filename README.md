# SpringCloudDemo
springcloud test

# 1. Eureka 组件
一个类似于zookeeper的服务注册与发现的组件
# eureka-server搭建
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

# eureka-client搭建
# 搭建步骤
 1.与server相同
 
 2.application启动类上开启注解@EnableDiscoveryClient，将服务注册至server
 
 ![](https://github.com/cestlavie21/imageRepository/blob/master/images/springCloudImages/eureka-client2.png)
 
 3.修改application.yml配置文件
 
 ![](https://github.com/cestlavie21/imageRepository/blob/master/images/springCloudImages/eureka-client1.png)
 
 4.写一个sayHello方法,方便测试
 
    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {

        return "provider:" + name;
    }

# 建立consumer服务去远程调用sayHello方法
1.创建consumer服务,采用restTemplate的方式去远程调用.将restTemplate注入spring容器

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
    
    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
  
2.使用restTemplate去调用远程服务，会通过服务名eureka-provider到注册中心找到对应的ip和端口 

    @Autowired
    RestTemplate restTemplate;

    public  String sayHello(String name){
        return  restTemplate.getForObject("http://eureka-provider/hello/"+name,String.class);
    }
 
# 2. 使用Feign的方式去远程调用
1.创建feignservice服务并添加注解 @EnableFeignClients 和依赖
        
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

2.创建FeignService, 使用@FeignClient来指明调用的服务，通过@RequestMapping()来指定调用的方法
```
@FeignClient(value = "eureka-provider",fallback = FeginServiceHystic.class)
public interface FeginService {
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
     String  sayHelloByFegin(@PathVariable String name);
}
```
3.创建controller，注入FeignService, 调用sayHelloByFegin方法
```
@RestController
public class HelloController {
    @Autowired
    FeginService feginService;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable String name ){
        System.out.println("this is fegin");
        return   feginService.sayHelloByFegin(name);
    }
}
```

# 3.Hystrix断路器
如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。
使用断路器可直接返回一个固定的值

1.fallback指定短路后的方法
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)

2.新建SchedualServiceHiHystric类实现FeginService接口,并实现方法
```
public class FeginServiceHystic  implements  FeginService{
    @Override
    public String sayHelloByFegin(String name) {
        return "sorry"+name;
    }
}
```

