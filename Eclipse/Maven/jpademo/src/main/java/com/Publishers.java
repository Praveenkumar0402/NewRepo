package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "publishers")
@Entity(name = "Publishers")

public class Publishers {

	@Id
	@Column(name = "pub_id")
	private int pub_id;

	@Column(name = "pub_name")
	private String pub_name;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	public int getPub_id() {
		return pub_id;
	}

	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}

	public String getPub_name() {
		return pub_name;
	}

	public void setPub_name(String pub_name) {
		this.pub_name = pub_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Publishers[Pub_id=" + pub_id + " ,Pub_name=" + pub_name + " ,City=" + city + " ,State=" + state
				+ " ,Country=" + country + "]";
	}

}
