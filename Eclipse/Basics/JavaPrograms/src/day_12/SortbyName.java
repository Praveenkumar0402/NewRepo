package day_12;
//
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.TreeMap;
//
//public class SortbyName {
//	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		TreeMap<String, Long> tm = new TreeMap<>();
//		for (int i = 0; i < 5; i++) {
//			System.out.println("Enter the Values:");
//			tm.put(sc.next(), sc.nextLong());
//		}
//		System.out.println(tm);
//		sc.close();
//	}
//
//}

interface Addable{  
    int add(int a,int b);  
}  
  
public class SortbyName{  
    public static void main(String[] args) {  
          
        // Multiple parameters in lambda expression  
        Addable ad1=(a,b)->(a+b);  
        System.out.println(ad1.add(10,20));  
          
        // Multiple parameters with data type in lambda expression  
        Addable ad2=(int a,int b)->(a+b);  
        System.out.println(ad2.add(100,200));  
    }  
}  