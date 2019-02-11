package com.spring.microservices.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.spring.microservices.entities.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

	@Query(value = "SELECT * FROM EMPLOYEE WHERE EMPNAME LIKE %?1% ", nativeQuery = true)
	public List<EmployeeEntity> findEmployeeByName(String empName);

	@Async
	@Query(value = "select e.jobTitle from EmployeeEntity e where e.empId= :empId")
	public List<Optional<String>> jobTitleById(@Param("empId") Integer empId);

	@Async
	@Query(value = "SELECT e.empName, d.deptName from EmployeeEntity e inner join DepartmentEntity d on e.department.deptId = d.deptId and e.empId= :empId ")
	public List<Object[]> getEmployeeNameAndDeptNameById(@Param("empId") Integer empId);

}
