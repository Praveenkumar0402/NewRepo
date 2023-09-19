package com;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="com.Student")
@Table(name="otostudent")

public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String stu_name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id",referencedColumnName = "pay_Id")
	private Payments payments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStu_Name() {
		return stu_name;
	}

	public void setStu_Name(String stu_Name) {
		stu_name = stu_Name;
	}

	public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}
	
	
}
