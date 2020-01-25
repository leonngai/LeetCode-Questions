class Solution {
    public String removeDuplicates(String S) {
        char[] input = S.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < input.length; i++) {
            if (stack.isEmpty())
                stack.push(i);
            else if (input[i] == input[stack.peek()]) {
                input[stack.pop()] = '*';
                input[i] = '*';
            }
            else
                stack.push(i);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < input.length; i++) {
            if (input[i] != '*')
                sb.append(input[i]);
        }
        
        return sb.toString();
    }
}
