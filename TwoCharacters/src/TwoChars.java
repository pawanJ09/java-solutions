import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TwoChars {

	public static void main(String[] args) {
		String str = "beabeefeab";
		int result = alternate(str);
		System.out.println("Result: " + result);
	}
	
	static int alternate(String s) {
		//Find distinct characters
        Set<String> strSet = new HashSet<String>();
        strSet.addAll(Arrays.asList(s.split("")));
        System.out.println(strSet);
        //Generate list of possible combinations
        List<String> inputList = new ArrayList<String>();
        inputList.addAll(strSet);
        List<String> strList = new ArrayList<String>();
        for(int i=0; i<strSet.size()-1; i++) {
        	for(int j=i; j<strSet.size()-1; j++) {
        		String a = inputList.get(i)+inputList.get(j+1);
        		strList.add(a);
        	}
        }
        System.out.println("List: " + strList);
        //Generate expected pattern by removing each combination from above list
        List<String> outputList = new ArrayList<String>();
        for(int i=0; i<strList.size(); i++) {
        	String str = s.replaceAll("[^"+strList.get(i)+"]", "");
        	System.out.println("After removing: " + strList.get(i) + " generated string: " + str);
        	boolean isValid = true;
        	for(int j=0; j<=str.length()-3; j++) {
        		if(str.charAt(j) != str.charAt(j+2)) {
        			isValid = false;
        			break;
        		}
        	}
        	if(isValid) {
        		outputList.add(str);
        	}
        }
        //Calculate length of first string
        return outputList.stream()
		         .sorted((e1, e2) -> e1.length()>e2.length() ? -1 : 1)
		         .findFirst()
		         .get()
		         .length();
    }

}
