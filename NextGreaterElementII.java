class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int max = Integer.MIN_VALUE;
        Stack<Pair> stack = new Stack<>();
        
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                Pair temp = stack.pop();
                res[temp.index] = nums[i];
            }
            stack.push(new Pair(nums[i], i));
            max = Math.max(max, nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                Pair temp = stack.pop();
                res[temp.index] = nums[i];
            }
            
            if (!stack.isEmpty() && stack.peek().val == max)
                res[stack.pop().index] = -1;
            if (stack.isEmpty())
                break;
        }
        
        return res;
    }
}

class Pair {
    int val;
    int index;
    
    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
