# DemoMicroservice
Repository to practice microservice concepts


![DemoMicroservice](https://user-images.githubusercontent.com/67855380/169711152-689c9f5c-4463-4649-8f1e-f36a67b8886a.jpg)

## 1. Steps to add Discovery Server and Client  

   a. For Discovery Server Microservice   	
	1. add `@EnableEurekaServer` to main class   
	2. Disable server to register as client  
	
	server.port=8001  
	eureka.client.fetch-registry=false 
	eureka.client.register-with-eureka=false  
	eureka.client.service-url.defaultZone=http://localhost:8001/eureka/   
	
   b. For Discovery Client Microservice  
	1. add `@EnableDiscoveryClient` to main class (Optional)   
	2. add `spring.application.name` property    
	3. add `eureka.client.service-url.defaultZone={server-url}`   
    
c. In microservice either use `feignclient` or `restemplate` with `@LoadBalanced` 
  
## 2. Steps to add Spring Cloud API Gateway 
