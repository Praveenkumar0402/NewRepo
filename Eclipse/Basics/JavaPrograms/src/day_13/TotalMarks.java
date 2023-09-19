package day_13;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TotalMarks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data:");
		int sum = 0;
		Pattern p = Pattern.compile("\\d+");
		String s = sc.nextLine();
		var m = p.matcher(s);
		while (m.find()) {
			sum += Integer.parseInt(m.group());
		}
		System.out.println(sum);
		sc.close();
	}

}