package day2;

import java.util.Scanner;

public class ArrayAvg {

	public static void main(String[] args) {
		int a[] = new int[10];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Values:");
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = input.nextInt();
			sum += a[i];
		}
		int x = sum / a.length;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > x) {
				System.out.println(a[i]);
			}
		}
		input.close();

	}

}