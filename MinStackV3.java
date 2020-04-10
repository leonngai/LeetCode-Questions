class MinStack {
    Stack<Integer> valStack;
    Stack<Integer> minStack;
        
    public MinStack() {
        valStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        if (valStack.isEmpty()) {
            valStack.push(x);
            minStack.push(x);
        }
        else {
            valStack.push(x);
            
            if (minStack.peek() >= x)
                minStack.push(x);
        }
    }
    
    public void pop() {
        if (top() == getMin())
            minStack.pop();
        
        valStack.pop();
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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
