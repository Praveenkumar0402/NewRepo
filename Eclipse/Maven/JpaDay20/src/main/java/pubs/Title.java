package pubs;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Title")
@Table(name="titles")
public class Title {
	
	@Id
	private String title_id;
	private String title;
	private String type;
	private String price;
	private String advance;
	private String royalty;
	private String ytd_sales;
	private String notes;
	private String pubdate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pub_id")
	private Publisher publishers ;
	
	public Publisher getPublishers() {
		return publishers;
	}
	public void setPublishers(Publisher publishers) {
		this.publishers = publishers;
	}
	
	public String getTitle_id() {
		return title_id;
	}
	
	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAdvance() {
		return advance;
	}
	public void setAdvance(String advance) {
		this.advance = advance;
	}
	public String getRoyalty() {
		return royalty;
	}
	public void setRoyalty(String royalty) {
		this.royalty = royalty;
	}
	public String getYtd_sales() {
		return ytd_sales;
	}
	public void setYtd_sales(String ytd_sales) {
		this.ytd_sales = ytd_sales;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	
	
	
}
