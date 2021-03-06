package com.spring.microservices.operations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.microservices.entities.DepartmentEntity;

public interface CommonOperation extends JpaRepository<DepartmentEntity, Integer> {

	@Query(value = "SELECT * FROM DEPARTMENT WHERE DEPTNAME LIKE %?1% ", nativeQuery = true)
	public List<DepartmentEntity> findDepartmentByName(String deptName);

}
