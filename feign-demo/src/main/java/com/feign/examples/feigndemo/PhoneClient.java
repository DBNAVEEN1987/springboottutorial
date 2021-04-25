package com.feign.examples.feigndemo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("phone-client")
public interface PhoneClient {
	@GetMapping("/phone")
	public String getPhone();
}
