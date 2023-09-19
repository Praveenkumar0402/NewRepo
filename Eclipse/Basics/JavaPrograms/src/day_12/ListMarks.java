package day_12;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ListMarks {
	public static void main(String[] args) throws IOException {
		var raf = new RandomAccessFile("Home\\Documents\\Praveen\\marks.dat", "rw");
		for (int i = 0; i < 20; i++) {
			int n = (int) Math.round(Math.random() * 100);
			raf.writeInt(n);
		}
		raf.seek(0);
		int l = (int) raf.length() / 4;
		for (int i = 0; i < l; i++)
			System.out.println(raf.readInt());
		raf.close();
	}
}