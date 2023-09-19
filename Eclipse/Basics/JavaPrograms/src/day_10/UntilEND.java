package day_10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UntilEND {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		var fw = new FileWriter("Home\\Documents\\Praveen\\names.txt");
		while (true) {
			String s = sc.next();
			if (s.equalsIgnoreCase("end")) {
				break;
			}
			fw.write(s.toUpperCase() + "\n");
		}
		fw.close();
		sc.close();
	}
}
