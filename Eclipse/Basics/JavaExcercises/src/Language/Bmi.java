package Language;

import java.util.Scanner;

public class Bmi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the height:");
		double h = sc.nextInt();
		System.out.println("Enter the weight:");
		double w = sc.nextDouble();

		h = h / 100;
		double b = (w / Math.pow(h, 2));
		System.out.println("BMI is:" + b);
		sc.close();
	}

}
