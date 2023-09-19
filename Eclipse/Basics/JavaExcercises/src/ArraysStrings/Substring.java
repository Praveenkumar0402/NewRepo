package ArraysStrings;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String s = sc.nextLine();
		System.out.println("Enter the Substring:");
		String s1 = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s1.length(); j++) {
				if (s.charAt(i) == s1.charAt(j)) {
					System.out.println(i);
				}
			}
		}

		sc.close();
	}

}
