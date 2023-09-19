package day9;

import java.util.Arrays;
import java.util.Scanner;

public class StringsbyLength {

	public static void main(String[] args) {
		String s[] = new String[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextLine();
		}
		Arrays.sort(s, (a,b) -> a.length() - b.length());
		for(String str:s) {
			System.out.println(str);
		}
		sc.close();
	}
}

