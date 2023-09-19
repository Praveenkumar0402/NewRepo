package ArraysStrings;

import java.util.Scanner;

public class Separating {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		StringBuffer sb = new StringBuffer(sc.nextLine());
		for (int i = 0; i < sb.length(); i++) {
			String s1 = sc.nextLine();
			if (s1.equals("END")) {
				break;
			}
			sb.append('-');
			sb.append(s1);
		}
		System.out.println(sb);
		sc.close();
	}
}
