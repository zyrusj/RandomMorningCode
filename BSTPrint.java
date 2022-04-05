package practice;

import java.util.ArrayList;

public class BSTPrint {

//	  25
//   /  \
//  15   40
// /  \	   \
//10  20   50
//	 / \
//	19  24

//10, 15, 19,25, 20, 40, 24, 50
//	ArrayList<Type> str = new ArrayList<Type>();
//	n log(n) implementation
	private static class OrderedNode {
	    int leftness;
	    int value;
	    int depth;

	    OrderedNode(int value, int leftness, int depth) {
	      this.leftness = leftness;
	      this.depth = depth;
	      this.value = value;
	    }

	    public String toString() {
	      return Integer.toString(this.value);
	    }
	  }
		public static void main(String[] args)
		{
			BinarySearchTree tree = new BinarySearchTree();
			tree.insert(25);
			tree.insert(40);
			tree.insert(50);
			tree.insert(45);
			tree.insert(15);
			tree.insert(10);
			tree.insert(20);
			tree.insert(24);
			tree.insert(19);
			
			ArrayList<OrderedNode> result = orderTree(tree.root, 0, 0);
		    for(int i =0; i < result.size(); i++) {
		     System.out.print(result.get(i));
		      System.out.print(" ");
		      }
			}
	 
		private static ArrayList<OrderedNode> orderTree(BinarySearchTree.Node n, int leftness, int depth) {
			ArrayList<OrderedNode> nodes = new ArrayList<>();
			nodes.add(new OrderedNode(n.key, leftness, depth));
			if(n.left != null) {
				nodes.addAll(orderTree(n.left, leftness - 1 , depth + 1));
			}
			
			if(n.right != null) {
				 nodes.addAll(orderTree(n.right, leftness + 1, depth + 1));
			}

		    //compare by leftness, and then by depth
		    nodes.sort((a,b) -> {
		      int cmp = Integer.compare(a.leftness,b.leftness);
		      if(cmp != 0) return cmp;
		      return Integer.compare(a.depth, b.depth);
		      });
		    
		    return nodes;
		}

		private static void print(BinarySearchTree.Node n) {
			System.out.print(n.key);
			System.out.print(" ");
		}

}
	

