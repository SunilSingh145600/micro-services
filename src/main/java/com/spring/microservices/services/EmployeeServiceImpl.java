package com.spring.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservices.daos.EmployeeDao;
import com.spring.microservices.entities.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void deleteEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(employee);
	}

	@Override
	public EmployeeEntity findByEmployeeId(Integer empId) {
		// TODO Auto-generated method stub
		return employeeDao.findByEmployeeId(empId);
	}

	@Override
	public List<EmployeeEntity> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.findAllEmployee();
	}

}
