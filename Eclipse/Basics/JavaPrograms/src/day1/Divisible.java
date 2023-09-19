package day1;

import java.util.Scanner;

public class Divisible {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number:");
		int x = input.nextInt();
		if (x % 3 == 0 && x % 5 == 0) {
			System.out.println("Display1");
		} else if (x % 3 == 0) {
			System.out.println("Display2");
		} else if (x % 5 == 0) {
			System.out.println("Display3");
		} else {
			System.out.println("Display4");
		}
		input.close();
	}

}