package ArraysandFunc;

import java.util.Scanner;

public class LargestFactor {

	public static int largest(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum = i;
			}
		}
		return sum;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value:");
		int num = sc.nextInt();
		int a = largest(num);
		System.out.println(a);
		sc.close();
	}

}
