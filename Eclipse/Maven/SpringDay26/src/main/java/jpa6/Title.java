package jpa6;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="titles")
public class Title {
	
	@Id
	@Column(name="title_id")
	private String titleid ;
	private String title;
	private Double price;
	private int pub_id;
	
	public String getTitleid() {
		return titleid;
	}
	public void setTitleid(String titleid) {
		this.titleid = titleid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getPub_id() {
		return pub_id;
	}
	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}
	@Override
	public String toString() {
		return "Title [titleid=" + titleid + ", title=" + title + ", price=" + price + ", pub_id=" + pub_id + "]";
	}
	
}
