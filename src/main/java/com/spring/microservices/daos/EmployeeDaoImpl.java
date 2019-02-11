package com.spring.microservices.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.microservices.entities.EmployeeEntity;
import com.spring.microservices.repositories.EmployeeRepo;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void saveEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		employeeRepo.delete(employee);
	}

	@Override
	public EmployeeEntity findByEmployeeId(Integer empId) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(empId).get();
	}

	@Override
	public List<EmployeeEntity> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

}
