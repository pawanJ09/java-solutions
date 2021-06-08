package com.pawanj09.sample;

import java.util.List;

public class SumOfNumbersInList {

	public static void main(String[] args) {
		calculateSumOfList(List.of(3, 5, 10, 12));

	}

	public static void calculateSumOfList(List<Integer> numbers) {
		int sum = numbers.stream()
					.reduce(0, (x, y) -> x+y);
		System.out.println("Sum of all numbers in List: " + sum);
	}
}
