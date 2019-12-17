class Solution {
    int ans = 0, count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    count = 0;
                    helper(grid, row, col);
                }
            }
        }
        
        return ans;
    }
    
    public void helper(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return;
        
        count++;
        if (count > ans)
            ans = count;
        
        grid[row][col] = 0;
        
        helper(grid, row - 1, col);
        helper(grid, row, col + 1);
        helper(grid, row + 1, col);
        helper(grid, row, col - 1);
    }
}
