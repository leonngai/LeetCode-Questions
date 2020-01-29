class MinStack {

    /*
        The basic idea is at every element in the stack, we will need to keep track of the number we are pushing to it but also the minimum
        value that we have seen so far up to this point. By doing this comparison during stack entry, all the methods to push, pop, get top and get min will run in constant time.
        
        Time Complexity: O(N)
        Space Complexity: O(N)
    */
    Element top;
    /** initialize your data structure here. */
    public MinStack() {
        top = null;
    }
    
    public void push(int x) {
        Element newTop = new Element(x);
        newTop.minSoFar = top == null ? x : Math.min(x, top.minSoFar);
        newTop.next = top;
        
        top = newTop;
    }
    
    public void pop() {
        if (top != null)
            top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.minSoFar;
    }
}

class Element {
    Element next;
    int val;
    int minSoFar;
    
    public Element(int val) {
        this.val = val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
