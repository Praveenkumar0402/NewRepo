package com;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "com.Products")
@Table(name = "products")

public class Products {

	@Id
	private Integer prodId;
	private String prodName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catCode")
	private Category categories;

	@OneToMany(mappedBy = "products",fetch = FetchType.LAZY)
	Set<Sales> sales;

	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Product [ProdId=" + prodId + ", ProdName=" + prodName + ", sales=" + sales + "]";
	}
}