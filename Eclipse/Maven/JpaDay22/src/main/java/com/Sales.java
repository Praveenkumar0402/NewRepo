package com;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "com.Sales")
@Table(name = "sales")
@NamedQuery(name = "Costly", query = "select s.products.prodName from com.Sales s group by s.products.prodName having sum(s.amount)>10000")
public class Sales {

	@Id
	private Integer invno;
	private String transdate;
	private Double amount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="prodid")
	private Products products;

	public Integer getInvno() {
		return invno;
	}

	public void setInvno(Integer invno) {
		this.invno = invno;
	}

	public String getTransdate() {
		return transdate;
	}

	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Sales [invno=" + invno + ", transdate=" + transdate + ", amount=" + amount + ", products=" + products
				+ "]";
	}

	

}
