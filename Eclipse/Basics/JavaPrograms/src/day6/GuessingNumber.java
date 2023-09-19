package day6;

import java.util.Scanner;

public class GuessingNumber {

	public static void main(String[] args) {
		int a = (int) Math.round(Math.random() * 25);
		Scanner sc = new Scanner(System.in);
		int k = 3;
		System.out.println("Enter the number:");
		for (int i = 0; i < k; i++) {
			int guess = sc.nextInt();
			if (guess == a) {
				System.out.println("you win");
				break;
			} else if (a > guess && i != k - 1) {
				System.out.println("Enter the highest value");
			} else if (a < guess && i != k - 1) {
				System.out.println("Enter the lowest value");
			} else
				System.out.println("you lose");
		}
		sc.close();
	}
}