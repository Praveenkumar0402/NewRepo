package day8;

import java.util.Scanner;

public class StudentMarks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the marks:");
		String s = sc.next();
		String[] s1 = s.split(",");
		double total = 0;
		int count = 0;
		for (String marks : s1) {
			try {
				total = total + Integer.parseInt(marks);
				count++;
			} catch (NumberFormatException ex) {

			}
		}
		System.out.println((int) total);
		System.out.println(total / count);
		sc.close();

	}

}