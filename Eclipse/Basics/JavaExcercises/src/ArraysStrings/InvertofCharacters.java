package ArraysStrings;

public class InvertofCharacters {

	public static void main(String[] args) {
		String s = "Java Is Good";
		StringBuffer s1 = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isUpperCase(c)) {
				c = Character.toLowerCase(c);
			} else if (Character.isLowerCase(s.charAt(i))) {
				c = Character.toUpperCase(c);
			}
			s1.append(c);
		}

		System.out.println(s1);
	}
}
