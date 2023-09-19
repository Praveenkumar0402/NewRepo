package inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Square")
@Table(name = "square")
@DiscriminatorValue("2")
public class Square extends Store {

	private int side;

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}
