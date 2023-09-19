package day3;

public class Square {
	private int side;

	public int getArea(int side) {
		return side * side;
	}

	public int getSide(int side) {
		return side;
	}

	public int getCircumference(int side) {
		return side * 4;
	}

	public Square(int side) {
		this.side = side;
	}

	public Square() {

	}

}
