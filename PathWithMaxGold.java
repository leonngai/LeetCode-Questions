class Solution {
    public int ans = 0;
    public int getMaximumGold(int[][] grid) {
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) 
                if (grid[i][j] != 0)
                    helper(grid, i, j, 0);
        }
        
        return ans;
    }
    
    public void helper(int[][] grid, int row, int col, int sum) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            ans = Math.max(ans, sum);
            return;
        }
        
        int val = grid[row][col];
        grid[row][col] = 0;
        
        helper(grid, row - 1, col, val + sum);
        helper(grid, row, col + 1, val + sum);
        helper(grid, row + 1, col, val + sum);
        helper(grid, row, col - 1, val + sum);
        
        grid[row][col] = val;
            
    }
}
