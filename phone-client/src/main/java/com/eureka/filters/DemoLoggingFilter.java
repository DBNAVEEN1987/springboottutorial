package com.eureka.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoLoggingFilter implements Filter {

	private static Logger logger = LoggerFactory
			.getLogger(DemoLoggingFilter.class);

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		logger.info("Inside logging filter: " + arg0.getParameter("demoParam"));
		System.out.println("SystemPrint: ");
		arg2.doFilter(arg0, arg1);

	}

}
