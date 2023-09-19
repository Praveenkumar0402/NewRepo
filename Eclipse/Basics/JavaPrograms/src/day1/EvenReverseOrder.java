package day1;

import java.util.Scanner;

public class EvenReverseOrder {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number:");
		int x = sc.nextInt();
		for (int i = x; i >= 0; i--) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		sc.close();
	}
}