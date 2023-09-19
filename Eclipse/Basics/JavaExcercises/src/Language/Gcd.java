package Language;

import java.util.Scanner;

public class Gcd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number1:");
		int a = sc.nextInt();
		System.out.println("Enter the number2:");
		int b = sc.nextInt();
		int hcf = 0;
		for (int i = 1; i <= a && i <= b; i++) {
			if (a % i == 0 && b % i == 0) {
				hcf = i;
			}
		}
		System.out.println(hcf);
		sc.close();
	}

}
