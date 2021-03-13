package intuit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class DigitsCount {

	public static void main(String[] args) {
		/*Count occurrences of each digit in a given number
		Example:
		Number=32315
		3=2,2=1,1=1,5=1*/
		int inputNumber = 32315;
		char[] inputArr = String.valueOf(inputNumber).toCharArray();
		Map<String, Integer> inputMap = new HashMap<String, Integer>();
		for(int i=0; i<inputArr.length; i++) {
			if(inputMap.containsKey(String.valueOf(inputArr[i]))) {
				int count = inputMap.get(String.valueOf(inputArr[i]));
				count++;
				inputMap.put(String.valueOf(inputArr[i]), count);
			} else {
				inputMap.put(String.valueOf(inputArr[i]), 1);
			}
		}
		Iterator<Entry<String, Integer>> it = inputMap.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println("Digit: " + entry.getKey() + " Count: " + entry.getValue());
		}
		
	}

}
