package com;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "com.Category")
@Table(name = "categories")
public class Category {

	@Id
	private String catCode;
	private String catDesc;

	@OneToMany(mappedBy = "categories")
	Set<Products> products;

	public String getCatCode() {
		return catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [catCode=" + catCode + ", catDesc=" + catDesc + ", products=" + products + "]";
	}

}