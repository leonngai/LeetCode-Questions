class Solution {
    /*
        Process:
        1. Start at the end and work towards the beginning since we know the end is guaranteed to be a 0
        2. While going down the temperature list, compare the current temp with what is in the stack
            2a. If the stack is empty then that means the answer is 0, we push this value and continue
            2b. If the value is less than what we peek into the stack, then we can calculate our result for this index as stack.peek - current index
        3. Return result once we have checked all values
        
        Time Complexity: O(N)
        Space Complexity: (N)
    
    */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        int index = result.length - 2;
        stack.push(T.length - 1);
        
        while(index >= 0) {
            while(!stack.isEmpty() && T[index] >= T[stack.peek()]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                result[index] = stack.peek() - index;
            }
            
            stack.push(index);
            index--;
        }
        
        return result;
    }
}
