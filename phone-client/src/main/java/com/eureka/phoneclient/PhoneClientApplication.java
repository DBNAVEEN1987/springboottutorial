package com.eureka.phoneclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.eureka.filters.DemoLoggingFilter;

@SpringBootApplication
@EnableDiscoveryClient
public class PhoneClientApplication {

	public static void main(String[] args) {
		if(args!=null){
			System.out.println(args[0]);
		}
		System.out.println(System.getProperty("demoProp"));
		System.out.println(System.getenv("demoEnv"));
		
		SpringApplication.run(PhoneClientApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<DemoLoggingFilter> filterRegistrationBean() {
		FilterRegistrationBean<DemoLoggingFilter> registerBean = new FilterRegistrationBean<DemoLoggingFilter>();
		registerBean.addUrlPatterns("/*");
		DemoLoggingFilter customURLFilter = new DemoLoggingFilter();

		registerBean.setFilter(customURLFilter);
		registerBean.setOrder(1); // set precedence
		return registerBean;
	}
}
