class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        while(true) {
            boolean hasRotten = false;
            boolean turnFreshToRotten = false;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 2 && !visited[row][col]) {
                        hasRotten = true;
                        grid[row][col] = 0;
                        
                        for (int[] direction : directions) {
                            int x = row + direction[0];
                            int y = col + direction[1];
                            
                            if (x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1 && grid[x][y] == 1) {
                                turnFreshToRotten = true;
                                grid[x][y] = 2;
                                visited[x][y] = true;
                            }
                                
                        }
                        
                    }
                }
            }
                if (!hasRotten)
                    break;
                if(turnFreshToRotten)
                    minutes++;
        }
        
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 1)
                        return -1;
                }
            }
        
        return minutes;
    }
}
