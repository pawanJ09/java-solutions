/**
 * 
 */

/**
 * @author pawanjaiswal
 * This Java program will help find max occurrences of characters in given string
 * Example
 * Input String: google
 * Max character occurrences: go
 * Max character count: 2
 *
 */
public class MaxOccurCharImpl {

	static int maxCount = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  String inputString = "google"; 
		  System.out.println("Input String: " + inputString); 
		  char[] maxArray = fetchMaxOccurences(inputString);
		  if(maxArray != null && maxArray.length>0) {
			  System.out.println("Maximum occurences of characters in input string: " + new String(maxArray));
			  System.out.println("Maximum count of characters in input string: " + maxCount);
		  } else {
			  System.out.println("Null array returned");
		  }
	}
	
	private static char[] fetchMaxOccurences(String inputString) {
		if(inputString != null && "".equalsIgnoreCase(inputString.trim())) {
			return null;
		} else {
			//Note: Initialize character array but may need to dynamically update the size
			char[] arr = new char[10];
			int currMaxCount = 0;
			//Complexity of N Log N Time as we are iterating through 2 loops
			for(int i=0; i<inputString.length(); i++) {
				//System.out.println("Max Count: " + maxCount);
				currMaxCount = 1;
				for(int j=i+1; j<inputString.length(); j++) {
					if((int)inputString.charAt(i) == (int)inputString.charAt(j)) {
						currMaxCount++;
						if(currMaxCount > maxCount) {
							//Clean previous values as current max is larger than previous max.
							//There can only be 1 higher max
							for(int x=0; x<arr.length; x++) {
								arr[x] = (char)0;
							}
							arr[0] = inputString.charAt(i);
							//Change maxCount to new current max count
							maxCount = currMaxCount;
						} else if (currMaxCount == maxCount) {
							//Add new max to the array
							updateArr(arr, inputString.charAt(i));
							//Change maxCount to new current max count
							maxCount = currMaxCount;
						}
						//System.out.println("Match found non single arr: " + new String(arr));
					}
				}
				//If no match is found then add to the array as 1 occurrence.
				//This should happen for first character in string or
				//if all are single characters in string
				if(currMaxCount == 1 && currMaxCount >= maxCount) {
					//Change maxCount to new current max count
					maxCount = currMaxCount;
					//Add new max to the array
					updateArr(arr, inputString.charAt(i));
					//System.out.println("Match found single arr: " + new String(arr));
				}
			}
			return arr;
		}
	}
	
	private static void updateArr(char[] arr, char input) {
		boolean addToArr = true;
		int z = 0;
		for(z=0; z<arr.length; z++) {
			if((int)input == (int)arr[z]) {
				//If already exists then don't add
				addToArr = false;
				break;
			} else if(arr[z] == 0) {
				//if array position is empty then break and add the new character at z location
				break;
			}
		}
		if(addToArr) {
			arr[z] = input;
		}
	}

}
