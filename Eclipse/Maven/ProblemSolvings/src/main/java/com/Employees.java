package com;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Employees")
@Table(name = "ecm_employee")
public class Employees extends Persons {

	private int empid;
	private int month;
	private double salaries;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getSalaries() {
		double sal = 0;
		if (month <= 3) {
			sal = salaries + (salaries * 0.2);
		} else if (month <= 6) {
			sal = salaries + (salaries * 0.4);
		} else if (month <= 9) {
			sal = salaries + (salaries * 0.6);
		} else if (month <= 12) {
			sal = salaries + (salaries * 0.8);
		}
		return sal;
	}

	public void setSalaries(double salaries) {
		this.salaries = salaries;
	}

}
