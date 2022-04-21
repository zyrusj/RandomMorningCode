package practice;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class numToWord {

	public static HashMap<Integer, String> numbers = new HashMap<Integer, String>();
	
	public static Hashtable<Integer, String> places = new Hashtable<Integer, String>(); //thousand, million, billion, trillion

	public static String convertToWord(int num) {
		int[] intTab = String.valueOf(num).chars().map(Character::getNumericValue).toArray();
		StringBuilder sb = new StringBuilder();
		//break by threes then append the place
		for (int i = 0; i < intTab.length ; i++) {
			if ((intTab.length-i-1) % 3  == 2) {
				sb.append(numbers.get(intTab[i]) + "hundred ");
			} else if ((intTab.length-i-1) % 3 == 1) {
				int key = intTab[i];
				sb.append(numbers.get(key*10));
			} else if ((intTab.length-i-1)  % 3 == 0) {
				sb.append(numbers.get(intTab[i]));
				sb.append(places.get((intTab.length-i-1) / 3));

			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		numbers.put(1, "one ");
		numbers.put(2, "two ");
		numbers.put(3, "three ");
		numbers.put(4, "four ");
		numbers.put(20, "twenty ");
		numbers.put(30, "thirty ");
		places.put(0, "");
		places.put(1, "thousand ");
		places.put(2, "million ");
		System.out.print(convertToWord(321321321));
//		System.out.print(1/3);
	}

}
