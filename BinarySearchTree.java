
public class BinarySearchTree {
	 
//	class Node:
//	   def __init__(self, data):
//	      self.left = None
//	      self.right = None
//	      self.data = data
    public class Node {
        int key;
        Node left, right;
 
        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
 
    // Root of BST
    Node root;
 
    // Constructor
    BinarySearchTree() { root = null; }
 
    BinarySearchTree(int value) { root = new Node(value); }
 
    public void insert(int key) { root = insertHelper(root, key); }
 
    
//	   def insert(self, data):
//    if self.data:
//       if data < self.data:
//          if self.left is None:
//             self.left = Node(data)
//          else:
//             self.left.insert(data)
//          elif data > self.data:
//             if self.right is None:
//                self.right = Node(data)
//             else:
//                self.right.insert(data)
//    else:
//       self.data = data
    /* A recursive function to
       insert a new key in BST */
    /* Why is this private instead of public? This method is only needed in this class and it would
       never be called by a person using a BST since it is intended to help with the insert method.
       A shortcut to think about is if you would use Object.method(), in this case BinarySearchTree.insertHelper()
       then it would be private, but since you would use BinarySearchTree.insert() then insert would be public
     */
//    Java method signature- privacyLevel modifiers(static, final, etc.) returnType methodName(pamatersToPass)
    private Node insertHelper(Node root, int key) {
    	
        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertHelper(root.left, key);
        else if (key > root.key)
            root.right = insertHelper(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }



}
