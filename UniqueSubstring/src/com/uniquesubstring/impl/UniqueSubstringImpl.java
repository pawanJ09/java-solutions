/**
 * 
 */
package com.uniquesubstring.impl;

/**
 * @author pawanjaiswal
 * This Java program will help find the smallest unique substring from an input string
 * matching all characters from the input array
 * 
 * Example
 * inputArray = x, y, z
 * inputString = xyyzyzyxxy
 * output = zyx
 *
 */
public class UniqueSubstringImpl {

	static int recursionCount = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] inputArray = {'a', 'b', 'c', 'd'};
		String inputString = "bacbaccabbddaacbcbbacdacd";
		String outputString = null;
		int start = 0;
		int end = inputArray.length-1;
		int totalSum = 0;
		for(int i=0; i<inputArray.length; i++) {
			totalSum = totalSum + (int)inputArray[i];
		}
		System.out.println("Input Array length: " + inputArray.length + " and input: " + new String(inputArray));
		System.out.println("Input String length: " + inputString.length() + " and input: " + inputString);
		System.out.println("Total Sum: " + totalSum);
		if(inputString.length() >= inputArray.length) {
			outputString = determineUniqueSubstring(inputString, inputArray.length, totalSum, start, end);
			System.out.println("------Match found: " + outputString);
			System.out.println("------Recursion Count: " + recursionCount);
		} else {
			System.out.println("Invalid input criterias specified");
		}
		
	}

	private static String determineUniqueSubstring(String inputString, int inputArrayLength, 
			int totalSum, int start, int end) {
		int sum = 0;
		int matchCount = 0;
		int iter = 0;
		recursionCount++;
		System.out.println("Invoking with start and end as: " + start + " " + end);
		String inputSubstring = null;
		if(end<inputString.length()) {
			inputSubstring = inputString.substring(start, end+1);
		} else {
			//Boundary condition
			inputSubstring = inputString.substring(inputString.length()-inputArrayLength, inputString.length());
		}
		System.out.println("Input Substring length: " + inputSubstring.length() + " and value: " + inputSubstring);
		//Linear complexity as time depends on n i.e. inputSubstring
		for(iter=0; iter<inputSubstring.length(); iter++) {
			sum = sum + (int)inputSubstring.charAt(iter);
			if(iter != (inputSubstring.length()-1) && 
					inputSubstring.charAt(iter) == inputSubstring.charAt(inputSubstring.length()-1)) {
				//Find the matching element with last element so we can skip that in subsequent searches
				matchCount=iter+1;
				break;
			}
		}
		if(sum == totalSum) {
			return inputSubstring;
		} else if(end>=inputString.length()) {
			return null;
		} else {
			if(matchCount == 0) {
				start++;
				end++;
			} else {
				//Update start and end by the matchCount so we can skip the common elements
				start = start + matchCount;
				end = end + matchCount;
			}
			return determineUniqueSubstring(inputString, inputArrayLength, totalSum, start, end);
		}
	}
}
