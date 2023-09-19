package springDay28pubs;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@Column(name = "au_id")
	private String auid;

	private String city;

	@ManyToMany(mappedBy = "authors")
	Set<Title> titles;

	public Set<Title> getTitles() {
		return titles;
	}

	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getId() {
		return auid;
	}

	public void setId(String id) {
		this.auid = id;
	}

}