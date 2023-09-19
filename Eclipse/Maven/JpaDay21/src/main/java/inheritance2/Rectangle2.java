package inheritance2;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Rectangle2")
@Table(name = "i3_rectangle")
public class Rectangle2 extends Store2 {
	
	private int length;
	private int breadth;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

}
