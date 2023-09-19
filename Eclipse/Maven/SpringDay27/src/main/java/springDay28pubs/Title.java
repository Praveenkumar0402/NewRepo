package springDay28pubs;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "titles")
public class Title {

	@Id
	@Column(name = "title_id")
	private String tid;
	private String title;
	private Double price;
	@Column(name = "ytd_sales")
	private Integer sales;
	private String type;

	@ManyToMany
	@JoinTable(name = "titleauthor", joinColumns = @JoinColumn(name = "title_id"), inverseJoinColumns = @JoinColumn(name = "au_id"))
	Set<Author> authors;
	
	
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pubid")
	private Publisher publishers;

	public Publisher getPublishers() {
		return publishers;
	}

	public void setPublishers(Publisher publishers) {
		this.publishers = publishers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return tid;
	}

	public void setId(String id) {
		this.tid = id;
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

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

}
