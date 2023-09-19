package day6;

public class ArrayRandomOrder {

	public static void main(String[] args) {
		int a[] = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) Math.round(Math.random() * 100);
		}
		for (int x : a) {
			if (x < 50) {
				System.out.print(" " + x);
			}
		}
		System.out.println();
		for (int x : a) {
			if (x >= 50) {
				System.out.print(" " + x);
			}
		}
	}
}
