class Solution {
    
    //Note: this solution will time out due to a stack overflow error, need to use dynamic programming instead
    public int minPathSum(int[][] grid) {
        return helper(grid, grid.length - 1, grid[0].length - 1);
    }
    
    public int helper(int[][]grid, int row, int col)  {
        //base case
        if (row == 0 && col == 0) {
            return grid[row][col];
        }
        if (row == 0) {
            return grid[row][col] + helper(grid, row, col - 1);
        }
        if (col == 0) {
            return grid[row][col] + helper(grid, row - 1, col);
        }
        
        return grid[row][col] + Math.min(helper(grid, row - 1, col), helper(grid, row, col - 1));
    }

}
