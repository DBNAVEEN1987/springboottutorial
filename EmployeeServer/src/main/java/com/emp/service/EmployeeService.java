package com.emp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emp.converters.EmployeeRequestConverter;
import com.emp.data.EmployeeRequest;
import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;



@Component
public class EmployeeService {
	@Autowired
	private EmployeeRequestConverter converter;
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Transactional
	public Employee save(EmployeeRequest request){
		Employee emp = converter.convertToModel(request);
		return empRepository.save(emp);
	}
}
