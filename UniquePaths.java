class Solution {
    /*
        Process:
        1. Use recursion to find number of paths to the start going from the end
        2. If at any point we end up at a 'point' outside of the grid we return 0
        3. If we reach the start return 1
        4. The answer of all number of paths is just the sum of going left first, then going right
        5. We can improve this algorithm by using top down memoization DP to keep track of paths that we have already traversed down
        6. This will improve the run time so that we only have to go down each path once
        7. This can be further optimized by getting rid of recursion using bottom up DP
        
        Time complexity without memoization: O(2 ^(N*M))
        Time Complexity with memoization: O(N*M)
        Space Complexity with bottom up DP: O(N*M)
        
    Top Down:
    public int uniquePaths(int m, int n) {
        return helper(m, n, new int[n][m]);
    }
    
    public int helper(int m, int n, int[][] grid) {
        if (m < 1 || n < 1)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        if (grid[n - 1][m - 1] > 0)
            return grid[n - 1][m - 1];
        
        grid[n - 1][m - 1] = helper(m - 1, n, grid) + helper(m, n - 1, grid);
        return grid[n - 1][m - 1];
    }
    */
    
    //Bottom up
    public int uniquePaths(int m, int n) {
        int result = 0;
        int[][] grid = new int[n][m];
        
        for (int row = 0; row < n; row++)
            grid[row][0] = 1;
        
        for (int col = 0; col < m; col++)
            grid[0][col] = 1;
        
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                grid[row][col] += grid[row - 1][col] + grid[row][col - 1];
            }
        }
        
        return grid[n - 1][m - 1];
    }
}
