package day8;

record Circle(int x, int y, double radius) {
	public void area() {
		System.out.println(Math.PI * radius * radius);
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public double radius() {
		return radius;
	}
}

public class RecordCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle(2, 3, 4);
		System.out.println(c1.toString());
		c1.area();
	}

}
