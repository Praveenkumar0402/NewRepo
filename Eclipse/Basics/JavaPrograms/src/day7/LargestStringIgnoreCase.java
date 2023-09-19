package day7;

import java.util.Scanner;

public class LargestStringIgnoreCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String max = "";
		while (true) {
			String s = sc.nextLine();
			if (s.isEmpty())
				break;
			else {
				int index = s.compareToIgnoreCase(max);
				if (index > 0) {
					max = s;
				}
			}
		}
		System.out.println(max);
		sc.close();
	}

}