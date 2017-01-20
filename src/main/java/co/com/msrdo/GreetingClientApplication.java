package co.com.msrdo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import co.com.msrdo.controller.ClientGreetingController;
import co.com.msrdo.controller.ClientGreetingHomeController;
import co.com.msrdo.service.ClientGreetingService;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(useDefaultFilters = false)
public class GreetingClientApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(GreetingClientApplication.class, args);
	}

	// A customized RestTemplate that has the ribbon load balancer build in
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// The service encapsulates the interaction with the micro-service.
	@Bean
	public ClientGreetingService helloWorldService() {
		return new ClientGreetingService();
	}

	// Create the controller, passing it the ClientGreetingService to use.
//	@Bean
//	public ClientGreetingController helloWorldController() {
//		return new ClientGreetingController(helloWorldService());
//	}

//	

}
