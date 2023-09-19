package day_12;

import java.util.Comparator;
import java.util.TreeSet;

public class SortbyLength {
	public static void main(String[] args) {
		TreeSet<String> ts=new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return 1;
				}else {
					return s1.length()-s2.length();
				}
			}
		});
		ts.add("Praveen Kumar");
		ts.add("ajay");
		ts.add("vishnu");
		ts.add("jack");
		ts.add("David");
		for(var names:ts)
		System.out.println(names);
		
	}

}