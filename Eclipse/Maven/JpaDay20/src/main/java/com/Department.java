package com;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="otm_department")
@Entity(name="Department")
public class Department {
	@Id
	private String dep_code;
	private String dep_name;

	@OneToMany(mappedBy = "otm_department", fetch = FetchType.LAZY) 
	private List<Employee> otm_employees = new ArrayList<Employee>();

	public List<Employee> getOtm_employees() {
		return otm_employees;
	}

	public void setOtm_employees(List<Employee> otm_employees) {
		this.otm_employees = otm_employees;
	}
	
	public String getDep_code() {
		return dep_code;
	}

	public void setDep_code(String dep_code) {
		this.dep_code = dep_code;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
}



