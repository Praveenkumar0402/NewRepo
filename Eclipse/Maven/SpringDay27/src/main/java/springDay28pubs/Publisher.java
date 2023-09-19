package springDay28pubs;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="publishers")
public class Publisher {
	
	@Id
	@Column(name="pub_id")
	private int pubid;
	private String city;
	
	@OneToMany(mappedBy = "publishers")
	List<Title> titl;

	public int getPubid() {
		return pubid;
	}

	public void setPubid(int pubid) {
		this.pubid = pubid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Title> getTitl() {
		return titl;
	}

	public void setTitl(List<Title> titl) {
		this.titl = titl;
	}

	}
