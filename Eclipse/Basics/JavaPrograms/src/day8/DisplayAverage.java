package day8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayAverage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int count = 0;
		double total = 0;
		while (true) {
			try {
				int n = sc.nextInt();
				if (n == 0)
					break;
				total += n;
				count++;
			} catch (InputMismatchException ex) {
				sc.next();
			}
		}
		System.out.println(total / count);
		sc.close();
	}
}