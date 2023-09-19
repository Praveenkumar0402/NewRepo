package day3;

import java.util.Scanner;

public class ArrSquare {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the values:");
		Square[] squares = new Square[5];
		for (int i = 0; i < squares.length; i++) {
			int num = input.nextInt();
			squares[i] = new Square(num);
			System.out.println(squares[i].getArea(num));
		}
		input.close();
	}

}
