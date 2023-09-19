package Language;

import java.util.Scanner;

public class Largest {

	public static void main(String[] args) {
		int a[] = new int[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the values:");
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			if (max < a[i]) {
				max = a[i];
			}
		}
		System.out.println(max);
		sc.close();
	}

}
