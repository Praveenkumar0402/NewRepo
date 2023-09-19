package ArraysStrings;

import java.util.Scanner;

public class SeparateLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String n = sc.nextLine();
		String s1[] = n.split(" ");

		for (String s2 : s1) {
			System.out.println(s2);
		}
		sc.close();
	}

}
