package com.feign.examples.feigndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class EmployeeController {
	@Autowired
	private PhoneClient phoneClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${demo.name}")
	private String name;

	@GetMapping("/feign")
	public String getDetails(){
		String phone = phoneClient.getPhone();
		return "feign-client: "+phone;
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@GetMapping("/phone")
	public String getPhoneDetails(){
		String phone = "";
		try {
			System.out.println("inside phone ");
			phone = restTemplate.getForObject("http://phone-client/phone", String.class);
		} catch (Exception exe) {
			System.out.println("exe: " + exe.getStackTrace().getClass());
		}

		return name + " test inside phone " + phone;
	}
}
