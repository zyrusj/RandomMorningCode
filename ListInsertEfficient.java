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

    }

    private static ArrayList<Integer> makeArray(Integer ... numbers) {
        return new ArrayList<>(Arrays.asList(numbers));
    }

    private static void putInOrder(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        if(l1.size() < l2.size())  throw new IllegalArgumentException("l1 size must not be less than l2");
        for (int i = l1.size(); i > 0 ; i--) {
            Integer e = l1.get(i - 1);
            if(INF != e)  l2.add(e);
        }
        int i = 0;
        int j = l2.size()-1;
        int k = 0;
        while(i <= j) {
            if(l2.get(i) < l2.get(j)) {
                l1.set(k, l2.get(i));
                i++;
            }
            else {
                l1.set(k, l2.get(j));
                j--;
            }
            k++;
        }
    }

}
