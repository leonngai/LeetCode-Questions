class Solution {
    public int minPathSum(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        
        for (int row = 1; row < rowLength; row++) {
            grid[row][0] += grid[row - 1][0];
        }
        
        for (int col = 1; col < colLength; col++) {
            grid[0][col] += grid[0][col - 1];
        }
        
        for (int row = 1; row < rowLength; row++) {
            for (int col = 1; col < colLength; col++) {    
                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        
        return grid[rowLength - 1][colLength - 1];
    }
}
