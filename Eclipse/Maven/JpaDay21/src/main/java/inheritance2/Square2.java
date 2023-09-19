package inheritance2;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Square2")
@Table(name = "i3_square")
public class Square2 extends Store2{
	
	private int side;

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}
