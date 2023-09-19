package day8;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DaysOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-uuuu");
		System.out.println("Enter the date:");
		LocalDate[] date = new LocalDate[5];
		int i = 0;
		while (i < date.length) {
			try {
				date[i] = LocalDate.parse(sc.next(), dt);
				i++;
			} catch (DateTimeException ex) {

			}
		}
		Arrays.sort(date);
		for (LocalDate s2 : date) {
			System.out.println(s2.format(dt));
		}
		sc.close();
	}

}