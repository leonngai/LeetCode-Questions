class Solution {
    public boolean isValid(String s) {
        //lets use a stack, everytime we see an opening we push it
        //everytime we see an ending, we pop it and compare
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[')
                stack.push(temp);
            
            else {
                if (stack.isEmpty())
                    return false;
            
                if (temp == ')') {
                    if ('(' != stack.pop())
                        return false;
                }
                else if (temp == '}') {
                    if ('{' != stack.pop())
                        return false;
                }
                else if (temp == ']') {
                    if ('[' != stack.pop())
                        return false;
                }
            }
        }
        
        //will return false if there are still elements in the stack, else returns true since its an empty stack and we have gone through all elements
        return stack.isEmpty();
    }
}
