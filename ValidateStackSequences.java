class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        
        int poppedIndex = 0;
        
        for (int n : pushed) {
            stack.push(n);
            while(!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }
        
        return stack.isEmpty();
    }
}
