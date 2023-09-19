package day2;

public class LargestNumber {

	public static void main(String[] args) {
		int a[] = new int[args.length];
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(args[i]);
			if (max < a[i]) {
				max = a[i];
			}
		}
		System.out.println(max);

	}

}