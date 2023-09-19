package Language;

import java.util.Scanner;

public class SmallestFactor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = sc.nextInt();

		int flag = 1;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i);
				flag = 0;
				break;
			}
		}
		if (flag == 1) {
			System.out.println(n);
		}
		sc.close();
	}
}
