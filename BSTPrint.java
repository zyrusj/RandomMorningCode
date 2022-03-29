package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import practice.BinarySearchTree.Node;

public class BSTPrint {
	
	
	//given a BST print the elements from left to right and top to bottom, and given all keys are different
	
//		25
//	   /  \
//	  15   40
//	 /  \	 \
//  10	 20   50
//		   \
//		    24
	
//	10, 15, 25, 20, 40, 24, 50
	
	//create a hashtable<int leftness, int[] values> that contained lists at each level. 
	//track max and min leftness and print each array going by leftness
//	<Key, value>
//	-2, {10}
//	-1, {15}
//	0, {25,20}
	
	public static void printByLeftness(BinarySearchTree tree) {

		// while the nodes aren't traversed get the data from each element  
		// if you got to the left child decrement the current leftness and if right increment current
		// check if it's a new max and if it is put a new array in the map and if not get the array from that key and append the value to the end 
		
		//once the iteration is done use a for loop to print every list starting from minLeftness to max
		
		Map<Integer, int[]> values = new HashMap<>();
		int maxLeftness = 0;
		int  minLeftness = 0; 
		int currentLefness = 0;
		
		
		
		//minLeft = -1
		for (int i = minLeftness; i < maxLeftness; i++ ) {
			System.out.print(values.get(i));
		}
		
		
	}
	
	//TODO: convert to BFS-currently this is a preorder traversal
	// recursive method loook at both children and print them. Recur based on 
	private void traverseBF(Node node) {
		if (node == null ) {return;}
		System.out.println(node.key);
		traverseBF(node.left);
		traverseBF(node.right);
	}
	
//		25
//	   /  \
//	  15   40
//	 /  \	 
//10	 20   

//What it does
//25, 15, 10, 20, 40
//What I want
//25, 15, 40, 10, 20

	
	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(25);
		tree.insert(40);
//		tree.insert(50);
//		tree.insert(45);
		tree.insert(15);
//		tree.insert(10);
//		tree.insert(20);
		
		printByLeftness(tree);
		
		// print inorder traversal of the BST
	}
	
}
