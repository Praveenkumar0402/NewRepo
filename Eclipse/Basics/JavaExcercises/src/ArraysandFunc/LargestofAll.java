package ArraysandFunc;

public class LargestofAll {
	public static void largest(int max, int... a) {
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		// Scanner input=new Scanner(System.in);
		largest(1, 2, 3, 42, 5, 6, 7, 8, 9);
	}
}
