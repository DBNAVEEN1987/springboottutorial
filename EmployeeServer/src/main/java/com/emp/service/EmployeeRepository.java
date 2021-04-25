package com.emp.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.emp.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public List<Employee> findByName(String name);

	public List<Employee> findByAgeEquals(Integer age);

	public List<Employee> findByNameLike(String name);

	@Query(name = "Select * from Employee e Inner join e.phones p where p.phoneNo = :phoneNo")
	public List<Employee> findByPhones(BigInteger phoneNo);

}
