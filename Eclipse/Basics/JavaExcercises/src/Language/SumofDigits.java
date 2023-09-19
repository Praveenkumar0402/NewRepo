package Language;

import java.util.Scanner;

public class SumofDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = sc.nextInt();
		int sum = 0;
		while (n != 0) {
			int r = n % 10;
			sum = sum + r;
			n /= 10;
		}
		System.out.println("Sum of Digits:" + sum);
		sc.close();
	}

}
