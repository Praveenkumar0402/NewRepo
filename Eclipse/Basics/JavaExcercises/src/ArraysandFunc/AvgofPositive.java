package ArraysandFunc;

public class AvgofPositive {

	public static void Positive(int n, int... a) {
		int sum = 0, j = 0, x;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				j++;
				sum = sum + a[i];

			}
		}
		x = sum / j;
		System.out.println(x);
	}

	public static void main(String[] args) {
		Positive(6, 4, 8, 9, 3, -6, -7);
	}
}
