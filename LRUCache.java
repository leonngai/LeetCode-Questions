class Node {
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}
class LRUCache {
    HashMap<Integer, Node> hash;
    Node head;
    Node tail;
    int size;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        hash = new HashMap<>();
        
        head = new Node(0,0);
        tail = new Node(0,0);
        head.prev = null;
        tail.next = null;
    }
    
    public int get(int key) {
        if (!hash.containsKey(key))
            return -1;
        
        Node temp = hash.get(key);
        moveToFront(temp);
        
        return temp.value;
    }
    
    public void put(int key, int value) {
        Node temp = new Node(key, value);
        
        if (hash.containsKey(key)) {
            Node old = hash.get(key);
            deleteNode(old);
            
            hash.put(key, temp);
            addToFront(temp);
        }
        
        else {
            hash.put(key, temp);
            addToFront(temp);
            if (size < capacity) {
                size++;
            }
            
            else {
                Node delTail = deleteTail();
                hash.remove(delTail.key);
            }
            
        }
    }
    
    public void moveToFront(Node temp) {
        this.deleteNode(temp);
        this.addToFront(temp);
    }
    
    public void addToFront(Node temp) {
        if (size == 0) {
            head.next = temp;
            temp.prev = head;
            
            temp.next = tail;
            tail.prev = temp;
        }
        
        else {
            temp.next = head.next;
            head.next.prev = temp;
            
            head.next = temp;
            temp.prev = head;
        }
    }
    
    public void deleteNode(Node temp) {
        Node before = temp.prev;
        Node after = temp.next;
        
        before.next = after;
        after.prev = before;
    }
    
    public Node deleteTail() {
        Node old = tail.prev;
        this.deleteNode(old);
        
        return old;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
