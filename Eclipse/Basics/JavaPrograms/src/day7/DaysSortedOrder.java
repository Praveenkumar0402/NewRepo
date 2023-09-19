package day7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DaysSortedOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-uuuu");
		System.out.println("Enter the date:");
		LocalDate[] date = new LocalDate[5];
		
		for (int i = 0; i < date.length; i++) {
			date[i] = LocalDate.parse(sc.next(),dt);
		}
		
		Arrays.sort(date);
		for (LocalDate s2 : date) {
			System.out.println(dt.format(s2));
		}
		sc.close();
	}	
}