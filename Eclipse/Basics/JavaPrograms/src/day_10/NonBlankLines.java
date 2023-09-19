package day_10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class NonBlankLines {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name:");
		String fn = sc.nextLine();
		try {
			var fr = new FileReader("Home\\Documents\\Praveen\\" + fn);
			LineNumberReader lr = new LineNumberReader(fr);
			while (true) {
				String s = lr.readLine();
				if (s == null)
					break;
				else if (s.isBlank())
					continue;
				else
					System.out.println(lr.getLineNumber() + "-" + s);
			}
			lr.close();

		} catch (FileNotFoundException e) {

		} catch (NullPointerException e) {

		}
		sc.close();
	}

}