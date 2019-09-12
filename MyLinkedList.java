package testing;

//singly linked list
class MyLinkedList {
    
	Node head;
	Node tail;
	
	class Node {
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	//1 -> 2 -> 3, index = 0
        Node cursor = head;
        int counter = 0;
        
        while(cursor != null && counter < index) {
        	cursor = cursor.next;
        	counter++;
        }
        
        if (cursor != null && counter == index) {
        	return cursor.val;
        }
        
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	
    	//adding to empty list
        if (head == null && tail == null) {
        	Node newNode = new Node(val);
        	head = tail = newNode;
        }
        
        //adding to existing list
        else if (head != null && head == tail) {
        	Node newNode = new Node(val);
        	newNode.next = head;
        	head = newNode;
        }
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	Node newNode = new Node(val);
    	
        //adding to empty list
    	if (head == null && tail == null) {
    		head = tail = newNode;
    	}
    	
    	else if (head != null && head != tail) {
    		tail.next = newNode;
    		tail = newNode;
    	}
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        Node cursor = head;
        int counter = 0;
        
        //get to right position
        while(cursor != null && counter < index - 1) {
        	cursor = cursor.next;
        	counter++;
        }
        
        if (cursor == null && counter == index) {
        	
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
