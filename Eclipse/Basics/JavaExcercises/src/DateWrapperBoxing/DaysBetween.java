package DateWrapperBoxing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetween {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-uuuu");
		System.out.println("Enter the date:");
		LocalDate date = LocalDate.parse(sc.next(), dt);
		System.out.println("Enter the date2:");
		LocalDate date2 = LocalDate.parse(sc.next(), dt);
		long years = ChronoUnit.DAYS.between(date, date2);
		System.out.println(years);
		sc.close();
	}
}
