package com;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeStreams {

	public static void main(String[] args) {
		System.out.println("range:" + primenumber(100));
	}

	public static List<Integer> primenumber(int n) {
		return IntStream.rangeClosed(2, n).filter(x -> isPrime(x)).boxed().sorted(Collections.reverseOrder())
				.collect(Collectors.toList());

	}

	private static boolean isPrime(int number) {
		return IntStream.range(2, number).noneMatch(i -> number % i == 0);
	}
}
