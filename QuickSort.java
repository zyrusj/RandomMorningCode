package practice;

import java.util.Arrays;
import java.util.Collection;

public class QuickSort {
	//use a pivot and recursive algorithm to sort a list
	//1. Pivot is in position in final sorted array
	//2. Items to the left are smaller
	//3. Items to the right are larger
	//For this example pivot will be the last item
//	{3,7,9,1,5,8,4};
	
	public static void quicksort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		if (low < high) {
				int pivot_location = paritition(arr, low, high+1);
				quicksort(arr, low, pivot_location-1);
				quicksort(arr, pivot_location+1, high);
		}
		
	}
	
	private static void quicksort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot_location = paritition(arr, low, high+1);
			quicksort(arr, low, pivot_location);
			quicksort(arr, pivot_location+1, high);
	}
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
//	private static int partition(int[] arr, int low, int high) {
//		int pivot = arr[low];
//		int leftwall = low;
//		
//		for (int i = low; i < high; i++) {
//			if (arr[i]< pivot) {
//				swap(arr, i, leftwall);
//				leftwall = leftwall + 1; 
//			}
//		}
//		swap(arr, low, leftwall);
//		
//		return(leftwall);
//	}
	static int paritition(int[] a, int lo, int hi) {
	    int pivot = a[lo]; 
	    System.out.println("Pivot is  " + pivot);
	   
	    int i = lo + 1; 	    
	    System.out.println("Low plus one is " + hi);
	    int j = hi; //stop index
	    System.out.println("High is " + hi);

	    //invariant 
	    // a[0,i) <= p and a[j, N] > p
	    // i                j
	    while (i < j) {
	      if (a[i] <= pivot) 
	      {i++;} //if a sub i is less than p just increment i
	      else {
	        int tooBig = a[i]; 
		    System.out.print("Current value at index is " + tooBig);

	        a[i] = a[j-1]; 
		    System.out.println(" and is being swapped with " + a[j-1]);

	        a[j-1] = tooBig;
	        j--;
	        
	      }
	    }
	    a[lo] = a[i-1];
	    a[i-1] = pivot;
	    
	    System.out.println("Current array is ") ;
	    printArray(a);
	    return i -1;
	    
	   
	  }
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] intArray = new int[]{3,7,9,1,5,8,4};
		printArray(intArray);
		quicksort(intArray);
		printArray(intArray);
	}
	
}
