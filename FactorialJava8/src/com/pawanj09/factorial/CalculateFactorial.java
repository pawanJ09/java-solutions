package com.pawanj09.factorial;

import java.util.stream.IntStream;

public class CalculateFactorial {

	public static void main(String[] args) {
		conventionalFactorial(5);
		System.out.println("Factorial using recursive method: " + recursiveFactorial(5));
		System.out.println("Factorial using Java8 streams method: " + functionalFactorial(5));
	}
	
	static void conventionalFactorial(int n) {
		int factorial = 1;
		for(int i=1; i<=n; i++) {
			factorial = factorial*i;
		}
		System.out.println("Factorial using convential method: " + factorial);
	}

	static int recursiveFactorial(int n) {
		if(n>=1) {
			return n*recursiveFactorial(n-1);
		} else {
			return 1;
		}
	}
	
	static int functionalFactorial(int n) {
		return IntStream.range(1, n+1).reduce(1, (x, y) -> x*y);
	}
	
}
