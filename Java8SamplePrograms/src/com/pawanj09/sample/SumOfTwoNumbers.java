package com.pawanj09.sample;

import java.util.Arrays;
import java.util.List;

public class SumOfTwoNumbers {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(2, 4);
		System.out.println("Sum of 2 numbers: " + integers.stream().reduce(0, SumOfTwoNumbers::sum));
	}
	
	static int sum(int a, int b) {
		return a + b;
	}
}
