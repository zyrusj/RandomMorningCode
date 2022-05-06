package practice;

public class DoubleLinkedList {
	Node head, tail;
	
	
	public class Node {
        int data;
        Node prev;
        Node next;
 
        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int d) { data = d; }
    }
	
//	public void insert(int val) {
//		if (head != null) {
//			head = new Node(val);
//		} else {
//			insertAfter(head, val);
//		}
//	}
	
	public void insertAfter(Node prev_Node, int new_data)
	{
	 
	    /*1. check if the given prev_node is NULL */
	    if (prev_Node == null) {
	        System.out.println("The given previous node cannot be NULL ");
	        return;
	    }
	 
	    /* 2. allocate node
	    * 3. put in the data */
	    Node new_node = new Node(new_data);
	 
	    /* 4. Make next of new node as next of prev_node */
	    new_node.next = prev_Node.next;
	 
	    /* 5. Make the next of prev_node as new_node */
	    prev_Node.next = new_node;
	 
	    /* 6. Make prev_node as previous of new_node */
	    new_node.prev = prev_Node;
	 
	    /* 7. Change previous of new_node's next node */
	    if (new_node.next != null)
	        new_node.next.prev = new_node;
	}
	
	//This causes an infinite loop on a circular DLL 
	//	but proves that it is circular
	//Display can be fixed but those are the requirements
	 public void display() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  	
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Prints each node by incrementing the pointer.  
  
            System.out.print("Current is " + current.data + " "); 
            if (current.prev != null) {
            	 System.out.print("Previous is  " + current.prev.data + " ");
            }
            if (current.next != null) {
           	 System.out.print("Next  is  " + current.next.data + " ");
           }
          	 System.out.println();

            current = current.next;  
        }  
    }  
	 
	 public void insert(int data) {  
	        //Create a new node  
	        Node newNode = new Node(data);  
	        //If list is empty  
	        if(head == null) {  
	            //Both head and tail will point to newNode  
	            head = tail = newNode;  
	            //head's previous will point to null  
	            head.prev = null;  
	            //tail's next will point to null, as it is the last node of the list  
	            tail.next = null;  
	        }  
	        //Add newNode as new tail of the list  
	        else {  
	            //newNode will be added after tail such that tail's next will point to newNode  
	            tail.next = newNode;  
	            //newNode's previous will point to tail  
	            newNode.prev = tail;  
	            //newNode will become new tail  
	            tail = newNode;  
	            //As it is last node, tail's next will point to null  
	            tail.next = null;  
	        }  
	    } 
	 
	 public static void main(String[] args) {
		 DoubleLinkedList dll = new DoubleLinkedList();
		 dll.insert(0);
		 dll.insert(1);
		 dll.insert(2);
		 dll.insert(3);
		 dll.insert(4);
		 dll.display();
	 }
	 
}
