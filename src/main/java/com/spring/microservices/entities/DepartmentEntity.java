package com.spring.microservices.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "department")
public class DepartmentEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deptid")
	private Integer deptId;
	@Column(name = "deptname")
	private String deptName;
	@Column(name = "annual_salary")
	private String annualSalary;
	@Column(name = "est_annual_sal_minus_furlougths")
	private String estAnnualSalMinusFur;

	@JsonIgnore
	@OneToOne(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	private EmployeeEntity employee;

	public DepartmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentEntity(Integer deptId, String deptName, String annualSalary, String estAnnualSalMinusFur,
			EmployeeEntity employee) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.annualSalary = annualSalary;
		this.estAnnualSalMinusFur = estAnnualSalMinusFur;
		this.employee = employee;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getEstAnnualSalMinusFur() {
		return estAnnualSalMinusFur;
	}

	public void setEstAnnualSalMinusFur(String estAnnualSalMinusFur) {
		this.estAnnualSalMinusFur = estAnnualSalMinusFur;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

}
