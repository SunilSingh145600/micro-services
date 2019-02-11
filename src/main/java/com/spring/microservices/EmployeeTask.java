package com.spring.microservices;

import com.spring.microservices.entities.EmployeeEntity;
import com.spring.microservices.services.EmployeeService;

public class EmployeeTask implements Runnable {

	private EmployeeEntity employeeEntity;
	private EmployeeService employeeService;

	public EmployeeTask() {
	}

	public EmployeeTask(EmployeeEntity employeeEntity, EmployeeService employeeService) {
		super();
		this.employeeEntity = employeeEntity;
		this.employeeService = employeeService;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(
					employeeEntity.getEmpName() + "-----------------------" + Thread.currentThread().getName());
			this.employeeService.saveEmployee(employeeEntity);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
