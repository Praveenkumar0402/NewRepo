package com;

public class Exception0 {
	public static void main(String[] args) {
		int n;
		try {
			n = Integer.parseInt(args[0]);
			if (99 % n == 0)
				System.out.printf("%d is a factor of 99", n);
		} catch (NumberFormatException ex) {
			System.out.println("Invalid number!");
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Number parameter is missing");
		}
	} // end of main
} // end of class
