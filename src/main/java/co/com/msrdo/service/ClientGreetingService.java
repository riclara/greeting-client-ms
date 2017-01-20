package co.com.msrdo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import co.com.msrdo.model.Greeting;

public class ClientGreetingService {
	
	@Autowired
    protected RestTemplate restTemplate;
	
	@Value("${greeting-service-url}")
    protected String serviceUrl;
 
    //invoke to greeting-service and return a Greeting object
    public Greeting greeting (String name) {
        Greeting greeting =  restTemplate.getForObject(serviceUrl + "/greeting/{name}",Greeting.class, name);
 
        return greeting;
    }

}
