package Language;

import java.util.Scanner;

public class Divisible {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number1:");
		int a = sc.nextInt();
		System.out.println("Enter the number2:");
		int b = sc.nextInt();

		if (a % 5 == 0 && b % 5 == 0) {
			System.out.println("Both are Divisible");
		}
		System.out.println("Not Divisible");
		sc.close();
	}

}
