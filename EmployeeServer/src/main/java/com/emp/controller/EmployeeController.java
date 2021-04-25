package com.emp.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeRepository;

@RestController
public class EmployeeController {
	// @Autowired
	// private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeRepository userRepository;
	

	// @GetMapping("/hello")
	// public String getDetails() {
	// String phone =
	// restTemplate.getForObject("http://phone-client/phone",String.class );
	// return phone;
	// }

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
		System.out.println("Inside employee controller");
		Optional<Employee> emp = userRepository.findById(id);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<Employee>(emp.get(), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/emps", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public @ResponseBody ResponseEntity<List<Employee>> getEmployees() {
		System.out.println("Inside employees controllers");
		List<Employee> employess = new ArrayList<Employee>();
		Iterable<Employee> emps = userRepository.findAll();
		emps.forEach(emp -> employess.add(emp));
		System.out.println(employess.size());
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity(employess, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/phone/{phoneNo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML })
	public @ResponseBody List<Employee> getEmployeeByPhone(@PathVariable("phoneNo") BigInteger phoneNo) {
		List<Employee> emp = userRepository.findByPhones(phoneNo);
		return emp;
	}


	// @Bean
	// @LoadBalanced
	// public RestTemplate getRestTemplate(){
	// return new RestTemplate();
	// }
}
