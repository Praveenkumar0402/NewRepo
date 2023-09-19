package day_11;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomMarks {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		RandomAccessFile ra = new RandomAccessFile("Home\\Praveen\\marks.dat", "rw");

		for (int i = 0; i < 20; i++) {
			int n = (int) Math.round(Math.random() * 100);
			ra.writeInt(n);
		}
		ra.seek(0);
		int l = (int) ra.length() / 4;
		for (int i = 0; i < l; i++)
			System.out.println(ra.readInt());
		
		sc.close();
		ra.close();
	}
}

