package com.eureka.phoneclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {
	@GetMapping("/phone")
	public String getPhone() {
		return "123654987";
	}
	
	@RequestMapping(value = "/phone", method = RequestMethod.POST, produces = { "application/json"}
	, consumes = {"application/json"})
	public @ResponseBody Phone addPhone(@RequestBody Phone phone) {
		System.out.println("phone: "+phone.getStdCode());
		phone.setId(null);
		return phone;
	}
}
