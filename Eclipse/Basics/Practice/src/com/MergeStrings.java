package com;

import java.util.Arrays;
import java.util.Scanner;

public class MergeStrings {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size:");
		int arr1 = sc.nextInt();

		String[] s1 = new String[arr1];
		for (int i = 0; i < s1.length; i++) {
			s1[i] = sc.next();
		}

		System.out.println("Enter the size:");
		int arr2 = sc.nextInt();

		String[] s2 = new String[arr2];
		for (int i = 0; i < s2.length; i++) {
			s2[i] = sc.next();
		}

		String[] s3 = new String[s1.length + s2.length];
		for (int i = 0; i < s1.length; i++) {
			s3[i] = s1[i];
		}

		for (int i = 0; i < s2.length; i++) {
			s3[i + s1.length] = s2[i];
		}
		System.out.println(Arrays.toString(s3));
		sc.close();
	}

}
