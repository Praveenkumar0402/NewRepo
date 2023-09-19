package day_11;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Marks {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		var fw = new FileWriter("Home\\Documents\\Praveen\\marks.xls");
		while (true) {
			String s = sc.next();
			if (s.equalsIgnoreCase("end")) {
				break;
			}
			fw.write(s+ "\n");
		}
		fw.close();
		sc.close();
	}

}
