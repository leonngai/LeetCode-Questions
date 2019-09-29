class Solution {
    
    // F(0) = 0,   F(1) = 1 ;   F(N) = F(N - 1) + F(N - 2), for N > 1.
    /*
        No memoization, simple if statement to say that if N == 0 or N == 1 then hard code those two values
        public int fib(int N) {
            if (N == 0) 
                return 0;
            else if (N == 1)
                return 1;

            return fib(N - 1) + fib(N - 2);
        }
    
    */
    int[] memo = new int[31];
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        memo[0] = 0;
        memo[1] = 1;
        return helper(memo, N);
    }
    
    public int helper(int[] memo, int N) {
        if (memo[N] > 0) {
            return memo[N];
        }
        
        memo[N] = fib(N - 1) + fib(N - 2);
        return memo[N];
    }
}
