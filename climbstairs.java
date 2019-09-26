ass Solution {
    
    public int climbStairs(int n) {
        int[] memoizationArray = new int[n + 1];
        return helper(n, 0, memoizationArray);
    }
    
    public int helper(int n, int result, int[] memo) {
        if (n == result) {
            return 1;
        }
        else if (result > n) {
            return 0;
        }
        
        if (memo[result] > 0) {
            return memo[result];
        }
        
        memo[result] = helper(n, result + 1, memo) + helper(n, result + 2, memo);
        return memo[result];
    }
    

}
