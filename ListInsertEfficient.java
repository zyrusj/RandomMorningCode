package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

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


        int j = l1.size() - l2.size() - 1;
        for (int i = l1.size()-1; !l2.isEmpty(); i--) {
            if(j < 0 || l1.get(j) <= l2.get(l2.size()-1)) {
                Integer largest = l2.remove(l2.size() - 1);
                l1.set(i, largest);
            }
            else {
               l1.set(i, l1.get(j));
               j--;
            }
        }

    }

}
