package jpademo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "products")
@Entity(name = "Product")

public class Product {
	@Id
	@Column(name = "ProdId")
	private int prodid;

	@Column(name = "ProdName")
	private String prodname;

	@Column(name = "Price")
	private Double Price;

	@Column(name = "Qoh")
	private int Qoh;

	@Column(name = "Remarks")
	private String Remarks;

	@Column(name = "Catcode")
	private String CatCode;

	public int getProdId() {
		return prodid;
	}

	public void setProdId(int prodid) {
		this.prodid = prodid;
	}

	public String getProdName() {
		return prodname;
	}

	public void setProdName(String prodname) {
		this.prodname = prodname;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		this.Price = price;
	}

	public int getQoh() {
		return Qoh;
	}

	public void setQoh(int Qoh) {
		this.Qoh = Qoh;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String Remarks) {
		this.Remarks = Remarks;
	}

	public String getCatcode() {
		return CatCode;
	}

	public void setCatcode(String Catcode) {
		this.CatCode = Catcode;
	}

	@Override
	public String toString() {
		return "Product[ProdId=" + prodid + ",ProdName=" + prodname + ",Price=" + Price + ",Qoh=" + Qoh + ",Remarks="
				+ Remarks + ",CatCode=" + CatCode + "]";
	}

}
