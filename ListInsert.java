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
	
	 public static final int INF = Integer.MAX_VALUE;

	    public static void main(String[] args) {
	    // write your code here
	    	
	        ArrayList<Integer> l1 = makeArray(1, 10, 20, INF, INF, INF);
	        ArrayList<Integer> l2 = makeArray(5, 9, 30);
	        System.out.println("Original " +l1);
	        putInOrder(l1, l2);

	        System.out.println(l1);
	        ArrayList<Integer> l3 = makeArray(1, 10, 20, INF, INF, INF);
	        ArrayList<Integer> l4 = makeArray(30, 32, 33);
	        putInOrder(l3, l4);

	        System.out.println(l3);

	        ArrayList<Integer> l5 = makeArray(9, 10, 20, INF, INF, INF);
	        ArrayList<Integer> l6 = makeArray(-1, 9, 11);
	        putInOrder(l5, l6);
	        System.out.println(l5);

	        									
	        ArrayList<Integer> l7 = makeArray(9, 10, 20, INF, INF, INF);
	        ArrayList<Integer> l8 = makeArray(-10, -9, 0);
	        putInOrder(l7, l8);
	        System.out.println(l7);

	    }
	    
	    private static ArrayList<Integer> makeArray(Integer ... numbers) {
	        return new ArrayList<>(Arrays.asList(numbers));
	    }

	    private static void putInOrder(ArrayList<Integer> l1, ArrayList<Integer> l2) {
	        if(l1.size() < l2.size())  throw new IllegalArgumentException("l1 size must not be less than l2");

	        //indices of list 0 through j 
	        int j = l1.size() - l2.size() - 1;
	        
	        //goes backwards from list1 until the second list is empty
	        for (int i = l1.size()-1; !l2.isEmpty(); i--) {
	        System.out.println("L2 " + l2);
	        // for i starting with on less than the size of the list
	        // while the list is not empty, decrement i
	        	
//	        for (int i = 0; i < list.size; i++)	
	        /*
	         * for i equals zero, while i is less than the size of the list, increment i	
	         */
	        
	        	
	        	// if you're not at the beginning or index j in the first list is 
	        	// less than or equal to the second list last element  
	            if(j < 0 || l1.get(j) <= l2.get(l2.size()-1)) {
	            	// get the largest integer
	                Integer largest = l2.remove(l2.size() - 1);
	                // set l1 at the index of i to the largest value 
	                l1.set(i, largest);
	            }
	            else {
	            	// set l1 at the index of i to the last element of j
	            	l1.set(i, l1.get(j));
	            	//decrement j
	            	j--;
	            	
	            }
	            System.out.println("L1 " + l1);
	        }

	    }

	
}
