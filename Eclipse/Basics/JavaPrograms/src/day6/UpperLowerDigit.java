package day6;

import java.util.Scanner;

public class UpperLowerDigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String s = sc.nextLine();
		int upper = 0, lower = 0, digit = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				upper++;
			} else if (Character.isLowerCase(s.charAt(i))) {
				lower++;
			} else if (Character.isDigit(s.charAt(i))) {
				digit++;
			}
		}
		System.out.println(upper);
		System.out.println(lower);
		System.out.println(digit);
		sc.close();
	}

}
