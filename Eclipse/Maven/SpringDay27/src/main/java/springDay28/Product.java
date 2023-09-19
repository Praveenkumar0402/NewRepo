package springDay28;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prodid")
	private Integer id;
	private String prodname;
	private double Price;
	private int Qoh;
	private String Remarks;
	private String catcode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getQoh() {
		return Qoh;
	}
	public void setQoh(int qoh) {
		Qoh = qoh;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public String getCatcode() {
		return catcode;
	}
	public void setCatcode(String catcode) {
		this.catcode = catcode;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", prodname=" + prodname + ", Price=" + Price + ", Qoh=" + Qoh + ", Remarks="
				+ Remarks + ", catcode=" + catcode + "]";
	}
	
}
