package practice;

import java.util.ArrayList;
import java.util.Arrays;



/*Given two sorted integer lists, one has empty spaces and the number of empty spaces 
 * are equal to the length of the second list. Insert the second list into the first
 * Assumes that nothing in l1 is equal anything in l2
 * ex: l1 = {1, 10, 20, _, _, _}; l2 = {5, 9, 30};
 * l1 = {1, 10, 20, MAX.int, MAX.int, MAX.int};
 * desired output = {1, 5, 9, 10, 20, 30}
 */

/*
 * Algorithm
 * Binary search for insert index. 
 * 
 */

public class ListInsert {
	
	public static void binaryInsert(int val, ArrayList<Integer> list){
		//binary search and insert
		
		//remove last element
		
	}
	
	private static int binarySearch(int val, ArrayList<Integer> list) {
		//Binary search algorithm: 
		
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList(Arrays.asList(1, 10, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));

		ArrayList<Integer> l2 = new ArrayList(Arrays.asList(5, 9, 30));
		for (int i = 0; i < l2.size(); i++ ) {
			binaryInsert(l2.get(i), l1);
		}
	}
	
	
}
