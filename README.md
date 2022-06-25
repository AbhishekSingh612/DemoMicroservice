# DemoMicroservice

Repository to practice microservice concepts

![Untitled Diagram (1)](https://user-images.githubusercontent.com/67855380/169911609-858e01cd-cafa-4503-88a2-343a154dcb7c.jpg)

## 1. Steps to add Discovery Server and Client

1. For Discovery Server Microservice
   1. add `@EnableEurekaServer` to main class
   2.  Disable server to register as client

       ```
        server.port=8001  
        eureka.client.fetch-registry=false 
        eureka.client.register-with-eureka=false  
        eureka.client.service-url.defaultZone=http://localhost:8001/eureka/   
       ```
2. For Discovery Client Microservice
   1. add `@EnableDiscoveryClient` to main class (Optional)
   2. add `spring.application.name` property
   3. add `eureka.client.service-url.defaultZone={server-url}`
3. In microservice either use `feignclient` or `restemplate` with `@LoadBalanced`

## 2. Steps to add Spring Cloud API Gateway
