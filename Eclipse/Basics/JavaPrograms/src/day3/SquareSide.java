package day3;

import java.util.Scanner;

public class SquareSide {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Values:");
		int n = input.nextInt();
		Square squares = new Square();

		System.out.println(squares.getArea(n));
		System.out.println(squares.getSide(n));
		System.out.println(squares.getCircumference(n));
		input.close();
	}

}
