package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Payments")
@Table(name="payments")

public class Payments {
	@Id
	@Column(name="amount")
	private double amount;
	
	private String dateofpayment;
	
	@OneToOne(mappedBy = "payments")
	private Student otostudent;


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDateofpayment() {
		return dateofpayment;
	}

	public void setDateofpayment(String dateofpayment) {
		this.dateofpayment = dateofpayment;
	}

	public Student getStudent() {
		return otostudent;
	}

	public void setStudent(Student otostudent) {
		this.otostudent = otostudent;
	}

}
