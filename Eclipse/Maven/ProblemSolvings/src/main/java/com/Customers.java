package com;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Customers")
@Table(name = "ecm_customer")
public class Customers extends Persons {

	private int custid;
	private String product;
	private double price;
	private int lpoints;

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getLpoints() {
		int lp = (int) (price / 200);
		return lp;
	}

	public void setLpoints(int lpoints) {
		this.lpoints = lpoints;
	}

}