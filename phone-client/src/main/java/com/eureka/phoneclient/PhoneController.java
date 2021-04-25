package com.eureka.phoneclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {
	@GetMapping("/phone")
	public String getPhone() {
		return "123654987";
	}
}
