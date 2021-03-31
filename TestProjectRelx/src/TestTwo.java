import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestTwo {

	public static void main(String[] args) {
		/*Write a java program to determine if the two
		array of String[] s1 = {"java", "swings", "j2ee",
		"struts", "jsp", "hibernate"} are String[] s2 =
		{"java", "struts", "j2ee", "hibernate", "swings",
		"jsp"} are equal?
		*/
		String[] s1 = {"java", "swings", "j2ee",
				"struts", "jsp", "hibernate"};
		String[] s2 =
			{"java", "struts", "j2ee", "hibernate", "swings",
			"jsp"};
		List<String> s1List = new ArrayList<String>();
		s1List.addAll(Arrays.asList(s1));
		Collections.sort(s1List);
		
		List<String> s2List = new ArrayList<String>();
		s2List.addAll(Arrays.asList(s2));
		Collections.sort(s2List);
		
		System.out.println(s1List.equals(s2List));
		/*
		 * A company named ABC Retail is in the
business of selling Books, CDs and
Cosmetics. Books are sales tax exempt and
CDs and Cosmetics have a sales tax of 10%.
CDs can be imported and attracts an import
tax of 5%. Write a simple program, which will
calculate extended price (qty * (unitprice +
tax)) inclusive of tax for each item?
		 */
		
	}

}
