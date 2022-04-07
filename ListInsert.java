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

    }

    private static ArrayList<Integer> makeArray(Integer ... numbers) {
        return new ArrayList<>(Arrays.asList(numbers));
    }

    private static void putInOrder(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        if(l1.size() < l2.size())  throw new IllegalArgumentException("l1 size must not be less than l2");
        ArrayList<Integer> l3 = new ArrayList<>();


        //invariant l1[i] < l2[j] and l1[i] < l3[k]
        for (int i = 0, j = 0, k = 0; i < l1.size(); i++) {

            final Integer itemI = l1.get(i);
            final Integer itemK = k < l3.size() ? l3.get(k) : INF;
            final Integer itemJ = j < l2.size() ? l2.get(j) : INF;
           
            if(itemI < itemK && itemI < itemJ ) continue;

            Integer outOfPlace = itemI;
            if(outOfPlace != INF) {
                l3.add(outOfPlace);
            }
            if(itemJ < itemK) {
                l1.set(i, itemJ);
                j++;
            }
            else  {
                l1.set(i, itemK);
                k++;
            }
        }
    }
}
