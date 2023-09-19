package day_10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentMarks {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name:");
		String fn = sc.nextLine();
		int sum = 0;
		try {
			var fr = new FileReader("Home\\Documents\\Praveen\\"+fn);
			var br=new BufferedReader(fr);
			while (true) {
				var s = br.readLine();
				if (s == null) {
					break;
				}
				String[] n = s.split(",");
				for (int i = 1; i < n.length; i++) {
					int mark = Integer.parseInt(n[i]);
					sum = sum + mark;
				}
				System.out.println(n[0] + "-" + sum);
				sum = 0;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry file not found");
		}catch(NumberFormatException e) {
			System.out.println("Please check the marks");
		}
		sc.close();
	}
}