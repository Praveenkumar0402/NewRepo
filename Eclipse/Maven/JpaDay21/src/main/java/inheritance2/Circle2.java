package inheritance2;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Circle2")
@Table(name = "i3_circle")
public class Circle2 extends Store2{
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
