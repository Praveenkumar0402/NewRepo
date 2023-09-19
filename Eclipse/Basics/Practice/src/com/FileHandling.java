package com;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class FileHandling {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		var fr = new FileReader("Home\\Documents\\Praveen\\marks.xls");
		LineNumberReader lr = new LineNumberReader(fr);
		System.out.println("Enter the roll no:");
		int rn = sc.nextInt();
		while (true) {
			String s = lr.readLine();
			if (s == null) {
				break;
			}

			if (lr.getLineNumber() == rn) {
				String[] num = s.split(",");
				for (int i = 0; i < num.length; i++) {
					System.out.print(num[i] + " ");
				}
			}
		}
		sc.close();
		lr.close();
	}
}
