package com.pawanj09.sample;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("Factorial: " + IntStream.range(1, 6)
		.boxed()
		.collect(Collectors.toList())
		.stream()
		.reduce(1, (x,y) -> x*y));
	}

}
