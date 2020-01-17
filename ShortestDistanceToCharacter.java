class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int[] shortestToChar(String S, char C) {
        //Can do two pass one from left -> right
        //One from right -> left and count how many spaces in between this while taking minimum of the two
        
        int[] result = new int[S.length()];
        int positionOfLastC = S.length() * -1;
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C)
                positionOfLastC = i;
            else
                result[i] = i - positionOfLastC;
        }
        
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C)
                positionOfLastC = i;
            else
                result[i] = Math.min(result[i], Math.abs(positionOfLastC - i));
        }
        
        return result;
    }
}

/*
Process:
    - Used stack to keep track of index of C and another stack for !C
    - Time Complexity: O(N)
    - Space Complexity: O(N)
    
        int[] result = new int[S.length()];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> eStack = new Stack<>();
        
        for (int i = 0; i < S.length(); i++) {
            if (eStack.isEmpty()) {
                if (S.charAt(i) != C) {
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty()) {
                        result[stack.peek()] = i - stack.pop();
                    }
                    eStack.push(i);
                }
            }
            else {
                if (S.charAt(i) != C) {
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty()) {
                        result[stack.peek()] = Math.min(i - stack.peek(), stack.pop() - eStack.peek());
                    }
                    eStack.pop();
                    eStack.push(i);
                }
            }
        }
        
        while(!stack.isEmpty() && !eStack.isEmpty()) {
            result[stack.peek()] = stack.pop() - eStack.peek();
        }
        
        return result;
*/
