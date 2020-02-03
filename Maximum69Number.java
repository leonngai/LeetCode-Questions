class Solution {
    public int maximum69Number (int num) {
        Stack<Integer> stack = new Stack<>();
        
        while(num > 0) {
            stack.push(num % 10);
            num /= 10;
        }
        
        int count = 0, res = 0;
        while (!stack.isEmpty()) {
            if (count == 0) {
                if (stack.peek() == 6) {
                    res = res * 10 + 9;
                    count++;
                    stack.pop();
                }
                else {
                    res = res * 10 + stack.pop();
                }
            }
            else {
                res = res * 10 + stack.pop();
            }
        }
        
        return res;
    }
}
