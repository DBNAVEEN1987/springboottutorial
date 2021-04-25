package com.feign.examples.feigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignDemoApplication.class, args);
	}
}
