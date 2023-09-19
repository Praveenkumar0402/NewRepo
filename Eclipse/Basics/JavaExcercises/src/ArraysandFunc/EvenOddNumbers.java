package ArraysandFunc;

public class EvenOddNumbers {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int even = 0, odd = 0;
		for (int i = 1; i < a.length; i++) {
			if (i % 2 == 0) {
				even = i;
				System.out.println(even);
			}
		}
		for (int i = 1; i < a.length + 1; i++) {
			if (i % 2 != 0) {
				odd = i;
				System.out.println(odd);
			}

		}

	}

}
