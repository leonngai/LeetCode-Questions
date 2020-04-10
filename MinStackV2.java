class Element {
    int val;
    int minSoFar;
    
    public Element(int val, int minSoFar) {
        this.val = val;
        this.minSoFar = minSoFar;
    }
}

class MinStack {
    Stack<Element> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Element(x, x));
        }
        else {
            stack.push(new Element(x, x < getMin() ? x : getMin()));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().minSoFar;
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
