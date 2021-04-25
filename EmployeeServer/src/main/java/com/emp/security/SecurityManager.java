package com.emp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityManager extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.jdbcAuthentication().dataSource(dataSource)
		 * .authoritiesByUsernameQuery("select employeeName, employeeRole FROM employee where employeeName=?"
		 * )
		 * .usersByUsernameQuery("select employeeName,employeePassword as password,1 FROM employee where employeeName=?"
		 * );
		 */
	}
}
