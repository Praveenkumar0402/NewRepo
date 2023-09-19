package day_10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LargerthanCharacters {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name");
		String fn = sc.nextLine();
		try {
			var fr = new FileReader("Home\\Documents\\Praveen\\" + fn);
			var br = new BufferedReader(fr);
			while (true) {
				var line = br.readLine();
				if (line == null) {
					break;
				} else if (line.length() > 10) {
					System.out.println(line);
				}
				br.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Sorry file not found");
		}
		sc.close();
	}
}