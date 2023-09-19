package ArraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class SortedOrder {

	public static void main(String[] args) {
		String[] s = new String[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");

		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextLine();
		}
		Arrays.sort(s);
		for (String s1 : s) {
			System.out.print(s1 + " ");
		}
		sc.close();
	}
}
