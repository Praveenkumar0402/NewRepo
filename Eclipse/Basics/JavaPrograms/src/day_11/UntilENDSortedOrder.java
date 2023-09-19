package day_11;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class UntilENDSortedOrder {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		var fw = new FileWriter("Home\\Documents\\Praveen\\names.txt");
		TreeSet<String> ts = new TreeSet<>();
		while (true) {
			String s = sc.next();
			if (s.equalsIgnoreCase("end"))
				break;
			ts.add(s);
		}
		for (var names : ts) {
			fw.write(names + "\n");
		}
		fw.close();
		sc.close();
	}
	
}