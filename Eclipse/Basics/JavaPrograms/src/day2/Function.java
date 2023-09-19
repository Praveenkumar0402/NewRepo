package day2;

public class Function {

	public static void main(String[] args) {
		wish("Hello", "Mark", "Jack", "Ajay", "David", "Kane");

	}

	public static void wish(String name, String... name1) {
		for (String n : name1) {
			System.out.println(name + " " + n);
		}
	}

}