package day_10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EachWordSeparate {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name:");
		String fn = sc.nextLine();
		try {
			var fr = new FileReader("Home\\Documents\\Praveen\\" + fn);
			var br = new BufferedReader(fr);
			while (true) {
				var line = br.readLine();
				if (line == null) {
					break;
				}
				String[] str = line.split(" ");
				for (var names : str) {
					System.out.println(names);
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry File not found");
		}
		sc.close();
	}
}