package com.emp.converters;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.emp.data.EmployeeRequest;
import com.emp.model.Employee;
import com.emp.model.Phone;

@Component
public class EmployeeRequestConverter {

	public Employee convertToModel(EmployeeRequest request) {
		Employee e1 = new Employee();
		e1.setAge(request.getAge());
		e1.setName(request.getName());
		Set<Phone> sp1 = convertToPhoneModel(request);
		e1.setPhones(sp1);
		return e1;
	}

	public Set<Phone> convertToPhoneModel(EmployeeRequest request) {
		com.emp.model.Phone p1 = new com.emp.model.Phone();
		p1.setPhoneNo(new BigInteger(request.getPhones().get(0).getNumber()));
		Set<com.emp.model.Phone> sp1 = new HashSet();
		sp1.add(p1);
		return sp1;
	}

}
