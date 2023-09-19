package day_12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class CountNames {
	public static void main(String[] args) throws IOException {
		var raf = new RandomAccessFile("Home\\Documents\\Praveen\\names.txt", "rw");
		HashMap<String, Integer> hm = new HashMap<>();
		int count = 0;
		while (true) {
			var s = raf.readLine();
			if (s == null) {
				break;
			}
			if (hm.containsKey(s)) {
				count = hm.get(s) + 1;
				hm.replace(s, count);
			} else {
				hm.put(s, 1);
			}
		}
		System.out.println(hm);
		raf.close();
	}
}