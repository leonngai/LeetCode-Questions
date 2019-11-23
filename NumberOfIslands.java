ss Solution {
    /*
    Go through the elements in the grid, everytime you see a 1, increment your count of islands by 1, then perform a DFS  with its neighbouring elements to mark it down as visited
    */
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    helper(grid, row, col);
                }
            }
        }
        
        return count;
    }
    
    public void helper(char[][] grid, int row, int col) {
        if (row == grid.length || row == grid[0].length || row < 0 || col < 0 || grid[row][col] == '0') 
            return;
        
        if (grid[row][col] == '1')
            grid[row][col] = '0';
        
        helper(grid, row - 1, col);
        helper(grid, row + 1, col);
        helper(grid, row, col - 1);
        helper(grid, row, col + 1);
    }
}
