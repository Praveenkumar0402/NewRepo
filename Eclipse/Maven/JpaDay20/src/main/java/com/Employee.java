package com;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="otm_employees")
@Entity(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	private String emp_name;
	private Double salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dep_code")
	private Department otm_department;
	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_Name() {
		return emp_name;
	}

	public void setEmp_Name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getOtm_Department() {
		return otm_department;
	}

	public void setOtm_Department(Department otm_department) {
		this.otm_department = otm_department;
	}

}
