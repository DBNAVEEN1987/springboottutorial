package com.eureka.phoneclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhoneClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneClientApplication.class, args);
	}
}
