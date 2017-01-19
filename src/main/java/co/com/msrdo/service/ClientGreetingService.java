package co.com.msrdo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import co.com.msrdo.model.Greeting;

public class ClientGreetingService {
	
	@Autowired
    protected RestTemplate restTemplate;
    protected String serviceUrl;
 
    public ClientGreetingService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" + serviceUrl;
    }
 
    //invoke to greeting-service and return a Greeting object
    public Greeting greeting (String name) {
        Greeting greeting =  restTemplate.getForObject(serviceUrl + "/greeting/{name}",Greeting.class, name);
 
        return greeting;
    }

}
