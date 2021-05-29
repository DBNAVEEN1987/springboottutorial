package com.feign.examples.feigndemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="phone-client")
public interface PhoneClient {
	@GetMapping("/phone")
	public String getPhone();
}
