package com.kingsley.servicediscoveryoneclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
public class ServicediscoveryoneClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicediscoveryoneClientApplication.class, args);
	}

	@RestController
	class ClientController {
		
		@Autowired
		private DiscoveryClient discoveryClient;
		
		@RequestMapping("/service-instances/{application-name}")
		public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName){
			return this.discoveryClient.getInstances(applicationName);
		}
		
	}
	
}
