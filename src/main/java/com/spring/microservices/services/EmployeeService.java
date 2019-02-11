package com.spring.microservices.services;

import java.util.List;

import com.spring.microservices.entities.EmployeeEntity;

public interface EmployeeService {
	public void saveEmployee(EmployeeEntity employee);

	public void deleteEmployee(EmployeeEntity employee);

	public EmployeeEntity findByEmployeeId(Integer empId);

	public List<EmployeeEntity> findAllEmployee();
}
