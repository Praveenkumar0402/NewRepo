package day9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AlphabetsDigits {
	public static void main(String[] args) {
		String[] s = new String[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.next();
		}
		Arrays.sort(s, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.parseInt(s1.substring(2)) - Integer.parseInt(s2.substring(2));
			}
		});
		for (String str : s) {
			System.out.println(str);
		}
		sc.close();
	}
}