package practice;
//Java program to demonstrate
//insert operation in binary
//search tree
class BinarySearchTree {

	/* Class containing left
	and right child of current node
	* and key value*/
	class Node {
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

	// This method mainly calls insertRec()
	void insert(int key) { root = insertRec(root, key); }

	/* A recursive function to
	insert a new key in BST */
	Node insertRec(Node root, int key)
	{

		/* If the tree is empty,
		return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls InorderRec()
	void inorder() { inorderRec(root); }

	// A utility function to
	// do inorder traversal of BST
	 public void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
	
	public DoubleLinkedList treeToDll() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		
		
		inorderDllInsert(dll, root);
		
		dll.head.prev = dll.tail;
		dll.tail.next = dll.head;
		
		return dll;
	}
	
	private void inorderDllInsert(DoubleLinkedList dll, Node root) {
		if (root != null) {
			inorderDllInsert(dll, root.left);
			dll.insert(root.key);
			inorderDllInsert(dll, root.right);
		}
	}
	
//	public static ListNode treeToList(BinarySearchTree.Node root) {
//	      if(root == null) return Empty;
//	      leftList = treeToList(root.left).addValue(root.value);
//	      leftList.append(treeToList(root.right));
//	      return leftList;
//	  }

	public void BFS() {
		int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
	}
	
	int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    /* Print nodes at the current level */
    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
	
	public void DFS() {
		
	}

	public void preorder() { preorderRec(root); }

	// A utility function to
	// do inorder traversal of BST
	void preorderRec(Node root)
	{
		if (root != null) {
			System.out.println(root.key);
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}
	
	public void postorder() { postorderRec(root); }

	// A utility function to
	// do inorder traversal of BST
	void postorderRec(Node root)
	{
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.println(root.key);
		}
	}
	
	/*A binary search tree and a circular doubly linked list are conceptually built from the same type
	 *of nodes - a data field and two references to other nodes. Given a binary search tree, rearrange
	 *the references so that it becomes a circular doubly-linked list (in sorted order) */ 
	
	
	
	// Driver Code
	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
		  50
		/	 \
	  30	 70
	  / \    / \
	 20 40  60 80 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		//Preorder (Root, Left, Right)
		tree.treeToDll().display();
	}
}








