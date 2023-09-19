package jpademo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customers")
@Entity(name = "Customer")
public class Customer {
	@Id
	@Column(name = "Cust_Name")
	private String Cust_Name;

	@Column(name = "Email")
	private String Email;

	@Column(name = "Mobile_Num")
	private String Mobile_Num;

	public String getCust_Name() {
		return Cust_Name;
	}

	public void setCust_Name(String Cust_Name) {
		this.Cust_Name = Cust_Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getMobile_Num() {
		return Mobile_Num;
	}

	public void setMobile_Num(String Mobile_Num) {
		this.Mobile_Num = Mobile_Num;
	}

	@Override
	public String toString() {
		return "Customer[Cust_Name=" + Cust_Name + "Email=" + Email + "Mobile_Num=" + Mobile_Num + "]";
	}
}
