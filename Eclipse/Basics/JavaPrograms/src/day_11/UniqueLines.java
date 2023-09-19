package day_11;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueLines {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		HashSet<String> hs = new HashSet<String>();
		RandomAccessFile ra = new RandomAccessFile("Home\\Documents\\Praveen\\names.txt", "rw");
		RandomAccessFile ra2 = new RandomAccessFile("Home\\Documents\\Praveen\\names2.txt", "rw");
		while (true) {
			var s = ra.readLine();
			if (s == null) {
				break;
			}
			hs.add(s);
		}
		while (true) {
			var s2 = ra2.readLine();
			if (s2 == null) {
				break;
			}
			hs.add(s2);
		}
		System.out.println(hs);
		ra.close();
		ra2.close();
		sc.close();
	}
}