package day_12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.TreeMap;

public class NameMobileSort {
	public static void main(String[] args) throws IOException {
		var raf = new RandomAccessFile("Home\\Documents\\Praveen\\customers.txt", "rw");
		TreeMap<String, String> tm = new TreeMap<>();
		while (true) {
			String s = raf.readLine();
			if (s == null) {
				break;
			}
			String[] s1 = s.split(" ");
			tm.put(s1[0], s1[1]);
		}
		System.out.println(tm);
		raf.close();
	}
}