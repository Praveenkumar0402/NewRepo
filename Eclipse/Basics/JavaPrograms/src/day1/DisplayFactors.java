package day1;

import java.util.Scanner;

public class DisplayFactors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number:");
		int x = sc.nextInt();
		for (int i = 1; i <= x; i++) {
			if (x % i == 0) {
				System.out.println(i);
			}
		}
		sc.close();
	}

}