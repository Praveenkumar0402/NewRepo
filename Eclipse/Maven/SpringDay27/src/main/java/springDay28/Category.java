package springDay28;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

	@Id
	private String catcode;
	private String catdesc;
	
	public String getCatcode() {
		return catcode;
	}
	public void setCatcode(String catcode) {
		this.catcode = catcode;
	}
	public String getCatdesc() {
		return catdesc;
	}
	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}

}
