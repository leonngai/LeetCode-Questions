class Solution {
    /*
        1. Repeatedly iterate through grid until we find land
        2. Check to the right, left, up and bottom of the coordinate and increment 1 to the perimeter if we are out of bounds or it is water
        3. Return the answer
        
        Time Complexity: O(R + C)
        Space Complexity: O(1)
    */
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans += calculatePerimeter(grid, i - 1, j);
                    ans += calculatePerimeter(grid, i, j + 1);
                    ans += calculatePerimeter(grid, i + 1, j);
                    ans += calculatePerimeter(grid, i, j - 1);
                }
            }
        }
        
        return ans;
    }
    
    public int calculatePerimeter(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return 1;
        
        return 0;
    }
}
