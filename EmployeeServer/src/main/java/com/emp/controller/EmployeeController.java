package com.emp.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.data.EmployeeRequest;
import com.emp.data.EmployeeResponse;
import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository userRepository;
	
	@Autowired
	private EmployeeService empService;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);


	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON})
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id,HttpServletRequest request) {
		logger.info("inside employee controller emp "+id);
		if(request!=null){
			logger.info("Request: "+request.getSession(false).getAttribute("USERNAME"));
		}
		
		
		Optional<Employee> emp = userRepository.findById(id);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<Employee>(emp.get(), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/emps", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public @ResponseBody ResponseEntity<List<Employee>> getEmployees(HttpServletRequest request) {
		logger.info("inside employee controller emps");
		if(request!=null){
			logger.info("Request: "+request.getSession(false).getAttribute("USERNAME"));
		}
		
		List<Employee> employess = new ArrayList<Employee>();
		Iterable<Employee> emps = userRepository.findAll();
		emps.forEach(emp -> employess.add(emp));
		logger.info(""+employess.size());
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity(employess, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/phone/{phoneNo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON})
	public @ResponseBody List<Employee> getEmployeeByPhone(@PathVariable("phoneNo") BigInteger phoneNo) {
		List<Employee> emp = userRepository.findByPhones(phoneNo);
		return emp;
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST, produces = { "application/json"}
	, consumes = {"application/json"})
	public @ResponseBody EmployeeResponse addEmployee(@RequestBody EmployeeRequest request) {		
		EmployeeResponse res1 = new EmployeeResponse();
		res1.setId(empService.save(request).getId());
		return res1;
	}	


}
