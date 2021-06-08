package com.pawanj09.sample;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfMultiples {

	public static void main(String[] args) {
		printSumOfMultiples(IntStream.range(1, 10).boxed().collect(Collectors.toList()));
	}

	public static void printSumOfMultiples(List<Integer> numbers) {
		System.out.println(numbers.stream().filter(x -> (x%3==0 || x%5==0)).reduce(0, (x,y) -> x+y));
	}
}
