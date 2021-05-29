package com.bootstraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emp.model.Address;
@SpringBootApplication
// @EnableDiscoveryClient
@ComponentScan(basePackages = { "com.*"})
@EnableJpaRepositories(basePackages = { "com.emp.repository" })
@EntityScan(basePackages = { "com.emp.model" })
public class SpringBootstraper {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootstraper.class, args);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Address.class);

	}

}
