package day2;

import java.util.Scanner;

public class Wages {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the input:");
		int days = input.nextInt();

		System.out.println("Enter the Hours:");
		int h = input.nextInt();

		int week = switch (days) {
		case 1, 2, 3 -> 100;
		case 4, 5 -> 125;
		case 6 -> 150;
		case 7 -> 200;
		default -> 0;
		};
		int sum = 0;
		sum = h * week;
		if (sum > 1000) {
			sum = (int) (sum + (sum * 0.1));
		}
		System.out.println(sum);
		input.close();
	}

}